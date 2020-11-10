package com.fadada.api.utils.crypt;

import com.fadada.api.utils.string.StringUtil;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class FddCryptUtil {

    private final static Charset UTF8 = StandardCharsets.UTF_8;

    public static byte[] hmac256(byte[] key, String msg) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, mac.getAlgorithm());
        mac.init(secretKeySpec);
        return mac.doFinal(msg.getBytes(UTF8));
    }

    public static String sha256Hex(String s) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] d = md.digest(s.getBytes(UTF8));
        return DatatypeConverter.printHexBinary(d).toLowerCase();
    }

    /**
     * @param sortParam 排序后得参数字符串
     * @param timestamp 时间戳
     * @param appKey    appKey
     * @return
     * @throws Exception
     */
    public static String sign(String sortParam,
                              String timestamp, String appKey) throws Exception {
        //将排序后字符串转为sha256Hex
        String signText = sha256Hex(sortParam);
        // ************* 计算签名 *************
        byte[] secretSigning = hmac256((appKey).getBytes(UTF8), timestamp);
        //计算后得到签名
        return DatatypeConverter.printHexBinary(hmac256(secretSigning, signText)).toLowerCase();
    }

    public static String sortParameters(Map<String, String> parameters) {
        if (parameters.isEmpty()) {
            return null;
        }
        List<String> removeKeys = new ArrayList<>();
        for (String key : parameters.keySet()) {
            if (StringUtil.isBlank(parameters.get(key))) {
                removeKeys.add(key);
            }
        }
        for (String key : removeKeys) {
            parameters.remove(key);
        }
        StringBuffer sb = new StringBuffer();
        SortedMap<String, String> paramMap = new TreeMap<>(parameters);
        int index = 0;
        for (String key : paramMap.keySet()) {
            String value = paramMap.get(key);
            sb.append(key).append("=").append(value);
            index++;
            if (index != parameters.size()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }
}

