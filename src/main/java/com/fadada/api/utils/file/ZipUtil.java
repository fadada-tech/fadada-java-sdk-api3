package com.fadada.api.utils.file;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解压文件， 编码类型（GBK）
 */
public class ZipUtil {
    private ZipUtil() {
    }

    /**
     * 解压压缩文件 (返回文件名 对应bytes)(GBK编码类型)
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static Map<String, byte[]> unZipByGBK(byte[] bytes) throws Exception {
        Map<String, byte[]> fileNameByteMap = new HashMap<>();
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bytes), Charset.forName("GBK"));
        ZipEntry zipEntry = zipInputStream.getNextEntry();

        while (zipEntry != null) {
            if (zipEntry.isDirectory()) {
                continue;
            } else {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                String fileName = zipEntry.getName();
                byte[] bufferBytes = new byte[1024];
                int len;
                while ((len = zipInputStream.read(bufferBytes, 0, bufferBytes.length)) != -1) {
                    bos.write(bufferBytes, 0, len);
                }
                bos.flush();
                bos.close();
                zipInputStream.closeEntry();
                fileNameByteMap.put(fileName, bos.toByteArray());
                zipEntry = zipInputStream.getNextEntry();
            }
        }
        zipInputStream.close();
        return fileNameByteMap;
    }


    /**
     * 解压到指定目录(GBK编码类型)
     *
     * @param bytes
     * @param filePath
     * @throws Exception
     */
    public static void unZipByGBK(byte[] bytes, String filePath) throws Exception {
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bytes), Charset.forName("GBK"));
        ZipEntry zipEntry = zipInputStream.getNextEntry();

        while (zipEntry != null) {
            if (zipEntry.isDirectory()) {
                continue;
            } else {
                String unZipFilePath = filePath + File.separator + zipEntry.getName();
                BufferedOutputStream bufferedOutputStream =
                        new BufferedOutputStream(new FileOutputStream(unZipFilePath));
                byte[] bufferBytes = new byte[1024];
                int len;
                while ((len = zipInputStream.read(bufferBytes, 0, bufferBytes.length)) != -1) {
                    bufferedOutputStream.write(bufferBytes, 0, len);
                }
                bufferedOutputStream.close();
            }
            zipInputStream.closeEntry();
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
    }


}
