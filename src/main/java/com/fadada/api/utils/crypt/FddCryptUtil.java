package com.fadada.api.utils.crypt;

import com.fadada.api.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Map;
import java.util.SortedMap;

/**
 * @author yanghui
 * @className FddCryptUtil
 * @description 序列化算法工具类
 * @createTime 2020年8月13日 15:31:59
 */
public class FddCryptUtil {
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static Logger logger = LoggerFactory.getLogger(FddCryptUtil.class);

    private FddCryptUtil() {
    }

    public static byte[] hmac256(byte[] key, String msg) throws ApiException {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(msg.getBytes(UTF8));
        } catch (Exception e) {
            logger.error("hmac256计算失败：{}", e);
            throw new ApiException("hmac256计算失败");
        }
    }

    public static String sha256Hex(String s) throws ApiException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] d = md.digest(s.getBytes(UTF8));
            return DatatypeConverter.printHexBinary(d).toLowerCase();
        } catch (Exception e) {
            logger.error("sha256Hex计算失败：{}", e);
            throw new ApiException("sha256Hex计算失败");
        }
    }


    /**
     * @param sortParam 排序后得参数字符串
     * @param timestamp 时间戳
     * @param secretKey secreKey
     * @return
     * @throws ApiException
     */
    public static String sign(String sortParam, String timestamp, String secretKey) throws ApiException {
        try {
            //将排序后字符串转为sha256Hex
            String signText = sha256Hex(sortParam);
            // ************* 计算签名 *************
            byte[] secretSigning = hmac256((secretKey).getBytes(UTF8), timestamp);
            //计算后得到签名
            return DatatypeConverter.printHexBinary(hmac256(secretSigning, signText)).toLowerCase();
        } catch (Exception e) {
            logger.error("sign计算失败：{}", e);
            throw new ApiException("sign计算失败");
        }
    }


    public static String sortParameters(SortedMap<String, String> paramMap) {
        StringBuilder paramStr = new StringBuilder();
        int index = 0;
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            paramStr.append(entry.getKey()).append("=").append(entry.getValue());
            index++;
            if (index != paramMap.size()) {
                paramStr.append("&");
            }
        }
        return paramStr.toString();
    }
}

