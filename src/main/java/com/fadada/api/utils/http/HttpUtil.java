package com.fadada.api.utils.http;

import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.document.DownLoadFileRsp;
import com.fadada.api.constants.GlobalConstants;
import org.apache.http.*;
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
import java.net.URI;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
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
     * 上传文件 post
     *
     * @param url
     * @param params
     * @param files
     * @return
     */
    private static HttpPost getHttpPost(String url, Map<String, String> params, Map<String, File> files) {
        HttpPost httpPost = new HttpPost(url);
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
//        httpPost.setConfig(getRequestConfig());
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
            // 添加代理
            HttpHost proxy = Boolean.TRUE.equals(PROXY_ON) ? addProxy() : null;
            // 初始化httpClient
            CloseableHttpClient httpClient = getHttpClient();
            // 创建http请求 设置请求参数
            HttpPost httpPost = null;
            if (files == null || files.isEmpty()) {
                httpPost = getHttpPost(url, params, GlobalConstants.CHARSET_UTF8);
            } else {
                httpPost = getHttpPost(url, params, files);
            }
            // 设置代理配置
            RequestConfig.Builder requestConfig = getRequestConfig();
            if (proxy != null) {
                requestConfig.setProxy(proxy);
            }
            httpPost.setConfig(requestConfig.build());

            return executeHttpRequest(httpClient, httpPost, reqHeader);
        } catch (Exception e) {
            log.error("url=[{}] http请求失败：{}", url, e);
        }
        return null;
    }

    /**
     * 获取client
     *
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        if (Boolean.TRUE.equals(PROXY_ON)) {
            return HttpClients.custom().build();
        } else {
            try {
                SSLContext ctx = SSLContexts.custom().useProtocol("TLSv1.2").build();
                return HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(ctx)).build();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static String get(String url, Map<String, String> reqHeader, Map<String, String> params) {
        // 添加代理
        HttpHost proxy = Boolean.TRUE.equals(PROXY_ON) ? addProxy() : null;
        // 初始化httpClient
        CloseableHttpClient httpClient = getHttpClient();
        // 创建http请求 设置请求参数
        HttpGet httpGet = getHttpGet(url, params, GlobalConstants.CHARSET_UTF8);
        // 设置代理配置
        RequestConfig.Builder requestConfig = getRequestConfig();
        if (proxy != null) {
            requestConfig.setProxy(proxy);
        }
        httpGet.setConfig(requestConfig.build());
        return executeHttpRequest(httpClient, httpGet, reqHeader);
    }


    public static String executeHttpRequest(CloseableHttpClient client, HttpUriRequest request, Map<String, String> reqHeader) {
        try {
            if (reqHeader != null && !reqHeader.isEmpty()) {
                for (Map.Entry<String, String> entry : reqHeader.entrySet()) {
                    request.addHeader(entry.getKey(), entry.getValue());
                }
            }
            HttpResponse response = client.execute(request);
            reqesutAndResponseLog(request, response);
            if (response.getStatusLine().getStatusCode() == GlobalConstants.SUCCESS_CODE_200) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            log.error("executeHttpRequest请求失败：{}", e);
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    log.error("CloseableHttpClient关闭失败：{}", e);
                }
            }
        }
        return null;
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
        // 添加代理
        HttpHost proxy = Boolean.TRUE.equals(PROXY_ON) ? addProxy() : null;
        // 初始化httpClient
        CloseableHttpClient httpClient = getHttpClient();
        try {
            // 创建http请求 设置请求参数
            HttpPost httpPost = getHttpPost(url, params, GlobalConstants.CHARSET_UTF8);
            if (reqHeader != null) {
                Iterator var4 = reqHeader.keySet().iterator();
                while (var4.hasNext()) {
                    String name = (String) var4.next();
                    httpPost.addHeader(name, reqHeader.get(name));
                }
            }
            // 设置代理配置
            RequestConfig.Builder requestConfig = getRequestConfig();
            if (proxy != null) {
                requestConfig.setProxy(proxy);
            }
            httpPost.setConfig(requestConfig.build());
            HttpResponse response = httpClient.execute(httpPost);
            reqesutAndResponseLog(httpPost, response);
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
        } catch (Exception e) {
            log.error("文件下载失败：{}", e);
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    log.error("CloseableHttpClient关闭失败：{}", e);
                }
            }
        }
        return result;
    }


    /**
     * 请求响应日志打印
     *
     * @param request
     * @param response
     */
    private static void reqesutAndResponseLog(HttpUriRequest request, HttpResponse response) {

        // 请求url
        URI uri = request.getURI();
        if (uri != null) {
            log.info("request url = [{}]", uri.toString());
        }

        // 获取请求头里面的nonce
        Header[] requestHeaders = request.getHeaders(GlobalConstants.FDD_NONCE);

        if (requestHeaders != null && requestHeaders.length > 0) {
            log.info("request header {}= [{}]", GlobalConstants.FDD_NONCE, requestHeaders[0].getValue());
        }

        // 获取响应头里面的requestId
        Header[] responseHeaders = response.getHeaders(GlobalConstants.FDD_REQEUST_ID);
        if (responseHeaders != null && responseHeaders.length > 0) {
            log.info("response header {}= [{}]", GlobalConstants.FDD_REQEUST_ID, responseHeaders[0].getValue());
        }
    }

    /**
     * 设置超时时间
     *
     * @return
     */
    private static RequestConfig.Builder getRequestConfig() {
        RequestConfig.Builder custom = RequestConfig.custom();
        if (SO_TIMEOUT != null) {
            custom.setSocketTimeout(SO_TIMEOUT);
        }
        if (CONNECT_TIMEOUT != null) {
            custom.setConnectTimeout(CONNECT_TIMEOUT);
        }

        return custom;
    }

    /**
     * 代理添加
     *
     * @return
     */
    private static HttpHost addProxy() {
        return new HttpHost(PROXYHOST, PROXYPORT, "http");
    }


}
