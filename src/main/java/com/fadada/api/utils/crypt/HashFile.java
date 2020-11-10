/**
 * 包名：com.yq365.utils.crypt
 * 文件名：com.yq365.utils.crypt
 * 创建者：zyb
 * 创建日：2015-3-9
 * <p>
 * CopyRight 2015 ShenZhen Fabigbig Technology Co.Ltd All Rights Reserved
 */
package com.fadada.api.utils.crypt;

import com.fadada.api.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 * @author yh128
 * @className HashFile
 * @description 文件Hash值
 * @createTime 2020年8月13日 15:32:24
 */
public class HashFile {
    private static Logger log = LoggerFactory.getLogger(HashFile.class);
    private static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private HashFile() {
    }

    /**
     * md5格式 <b>作者：</b>mybaby </br> <b>日期：</b>2015-3-9 </br>
     *
     * @param filename
     * @return
     */
    public static String getFileMD5(String filename) throws ApiException {
        try {
            return getHash(filename, "MD5");
        } catch (Exception e) {
            log.error("文件名MD5失败：{}", e);
            throw new ApiException("文件名MD5失败");
        }
    }

    public static String getFileSHA256(File file) throws ApiException {
        try (InputStream fis = new FileInputStream(file)) {

            byte[] buffer = new byte[1024];
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            int numRead;
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
            }
            return toHexString(md5.digest());
        } catch (Exception e) {
            log.error("文件SHA256失败：{}", e);
            throw new ApiException("文件SHA256失败");
        }
    }


    public static String getFileSHA256(String filename) throws ApiException {
        try {
            return getHash(filename, "SHA-256");
        } catch (Exception e) {
            log.error("文件名称SHA256失败：{}", e);
            throw new ApiException("文件名称SHA256失败");
        }
    }


    private static String getHash(String fileName, String hashType) throws ApiException {

        MessageDigest md5;
        try (InputStream fis = new FileInputStream(fileName);) {
            byte[] buffer = new byte[1024];
            md5 = MessageDigest.getInstance(hashType);
            int numRead;
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
            }
            return toHexString(md5.digest());
        } catch (Exception e) {
            log.error("文件名称获取Hash值失败：{}", e);
            throw new ApiException("文件名称获取Hash值失败");
        }
    }

    private static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[((b[i] & 0xF0) >>> 4)]);
            sb.append(hexChar[(b[i] & 0xF)]);
        }
        return sb.toString();
    }
}