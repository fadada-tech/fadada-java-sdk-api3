package com.fadada.api.utils.http;

import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.constants.GlobalConstants;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * HTTP工具类.
 *
 * @author
 */
public class HttpUtil {
    public static Integer CONNECT_TIMEOUT;
    public static Integer SO_TIMEOUT;
    public static Boolean PROXY_ON;
    public static String PROXYHOST;
    public static Integer PROXYPORT;


    private HttpUtil() {
    }

    /**
     * 默认编码方式 -UTF8
     */
    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    private static HttpGet getHttpGet(String url, Map<String, String> params, String encode) {
        StringBuilder buf = new StringBuilder(url);
        if (params != null) {
            // 地址增加?或者&
            String flag = (url.indexOf('?') == -1) ? "?" : "&";
            // 添加参数
            for (Map.Entry<String, String> entry : params.entrySet()) {
                buf.append(flag);
                buf.append(entry.getKey());
                buf.append("=");
                try {
                    String param = entry.getValue();
                    if (param == null) {
                        param = "";
                    }
                    buf.append(URLEncoder.encode(param, encode));
                } catch (UnsupportedEncodingException e) {
                    log.error("URLEncoder Error,encode=" + encode + ",param=" + entry.getValue(), e);
                }
                flag = "&";

            }
        }
        return new HttpGet(buf.toString());
    }


    /**
     * <b>概要：</b>
     * 下载文件保存到本地
     * <b>作者：</b>SUXH </br>
     * <b>日期：</b>2015-3-14 </br>
     *
     * @param path 文件保存位置
     * @param url  文件地址
     * @return
     * @throws IOException
     */
    public static boolean downloadFile(String path, String url) {
        HttpResponse response = null;
        try (CloseableHttpClient client = HttpClients.createDefault();
             FileOutputStream fos = new FileOutputStream(path);
             BufferedOutputStream bw = new BufferedOutputStream(fos)) {
            // 创建HttpClient对象
            // 获得HttpGet对象
            HttpGet httpGet = getHttpGet(url, null, null);
            response = client.execute(httpGet);
            // 如果成功
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                log.info("###downloadFile download Ready. ");
                byte[] result = EntityUtils.toByteArray(response.getEntity());
                // 创建文件对象
                File f = new File(path);
                if (f.exists()) {
                    Files.delete(f.toPath());
                }
                // 创建文件路径
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                // 写入文件
                bw.write(result);
            }
            // 如果失败
            else {
                return false;
            }
        } catch (Exception e) {
            log.error("###downloadFile 下载文件保存到本地,程序发生异常。 ERROR_MSG:" + e.getMessage(), e);
            return false;
        }
        return true;
    }


    /**
     * 上传文件 post
     *
     * @param url
     * @param params
     * @param files
     * @return
     */
    private static HttpPost getHttpPost(String url, Map<String, String> params, Map<String, File> files) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(getRequestConfig());
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        if (files != null && !files.isEmpty()) {
            for (Map.Entry<String, File> kv : files.entrySet()) {
                String fileName = kv.getValue().getName();
                multipartEntityBuilder.addBinaryBody(kv.getKey(), kv.getValue(),
                        ContentType.create("multipart/form-data", Consts.UTF_8), fileName);
            }
        }
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                multipartEntityBuilder.addTextBody(key, value, ContentType.TEXT_PLAIN.withCharset(GlobalConstants.CHARSET_UTF8));
            }
            multipartEntityBuilder.setMode(HttpMultipartMode.RFC6532);
        }
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);
        return httpPost;
    }

    /**
     * post请求
     *
     * @param url
     * @param params
     * @return
     */
    private static HttpPost getHttpPost(String url, Map<String, String> params, String charset) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(getRequestConfig());
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> list = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key, value);
                list.add(basicNameValuePair);
            }
            UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(list, charset);
            httpPost.setEntity(httpEntity);
        }
        return httpPost;
    }

    public static String post(String url, Map<String, String> reqHeader, Map<String, String> params,
                              Map<String, File> files) {
        try {
            HttpPost httpPost = null;
            if (files == null || files.isEmpty()) {
                httpPost = getHttpPost(url, params, GlobalConstants.CHARSET_UTF8);
            } else {
                httpPost = getHttpPost(url, params, files);
            }
            return executeHttpRequest(httpPost, reqHeader);
        } catch (Exception e) {
            log.error("url=[{}] http请求失败：{}", url, e);
        }
        return null;
    }

    public static String get(String url, Map<String, String> reqHeader, Map<String, String> params) {
        HttpGet httpGet = getHttpGet(url, params, GlobalConstants.CHARSET_UTF8);
        return executeHttpRequest(httpGet, reqHeader);
    }


    public static String executeHttpRequest(HttpUriRequest request, Map<String, String> reqHeader) {
        HttpClient client = null;
        String result = null;
        try {
            //根据配置文件配置代理服务器
            if (Boolean.TRUE.equals(PROXY_ON)) {
                client = getProxyHttpClient();
            } else {
//                SSLContext ctx= SSLContext.getInstance("TLSv1.2");
                SSLContext ctx = SSLContexts.custom().useProtocol("TLSv1.2").build();
                client = HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(ctx)).build();
            }
            if (reqHeader != null && !reqHeader.isEmpty()) {
                for (Map.Entry<String, String> entry : reqHeader.entrySet()) {
                    request.addHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == GlobalConstants.SUCCESS_CODE_200) {
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            log.error("executeHttpRequest请求失败：{}", e);
        } finally {
            if (client != null) {
                try {
                    ((CloseableHttpClient) client).close();
                } catch (IOException e) {
                    log.error("CloseableHttpClient关闭失败：{}", e);
                }
            }
        }
        return result;
    }

    /**
     * 下载文件
     *
     * @param url
     * @param reqHeader
     * @param params
     * @return
     */
    public static Object downLoadFiles(String url, Map<String, String> reqHeader, Map<String, String> params) {
        BaseRsp<DownLoadFileRsp> result = null;
        CloseableHttpClient client = null;
        try {
            HttpPost request = getHttpPost(url, params, GlobalConstants.CHARSET_UTF8);
            client = HttpClients.createDefault();
            if (reqHeader != null) {
                Iterator var4 = reqHeader.keySet().iterator();
                while (var4.hasNext()) {
                    String name = (String) var4.next();
                    request.addHeader(name, reqHeader.get(name));
                }
            }
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == GlobalConstants.SUCCESS_CODE_200) {
                HttpEntity respEntity = response.getEntity();
                Header contentType = respEntity.getContentType();
                if (contentType.getValue().contains(ContentType.APPLICATION_JSON.getMimeType())) {
                    return EntityUtils.toString(response.getEntity());
                } else {
                    byte[] bytes = EntityUtils.toByteArray(response.getEntity());
                    result = new BaseRsp();
                    DownLoadFileRsp fileRsp = new DownLoadFileRsp();
                    fileRsp.setFileBytes(bytes);
                    fileRsp.setContentType(contentType.getValue());
                    result.setData(fileRsp);
                }
            }
        } catch (IOException e) {
            log.error("文件下载失败：{}", e);
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    log.error("CloseableHttpClient关闭失败：{}", e);
                }
            }
        }
        return result;
    }


    private static CloseableHttpClient getProxyHttpClient() {
        HttpHost proxy = new HttpHost(PROXYHOST, PROXYPORT, "http");
        //把代理设置到请求配置
        RequestConfig defaultRequestConfig = RequestConfig.custom().setProxy(proxy).build();
        //实例化CloseableHttpClient对象
        return HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
    }

    /**
     * 获取请求配置
     *
     * @return
     */
    private static RequestConfig getRequestConfig() {
        RequestConfig.Builder custom = RequestConfig.custom();
        // 如果请求使劲不为空就设置值，为空就不设置超时时间，默认不设置超时时间
        if (SO_TIMEOUT != null) {
            custom.setSocketTimeout(SO_TIMEOUT);
        }
        if (CONNECT_TIMEOUT != null) {
            custom.setConnectTimeout(CONNECT_TIMEOUT);
        }

        return custom.build();
    }

}
