package com.fadada.api;


import com.fadada.api.exception.ApiException;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author yh128
 * @className FadadaApiService
 * @description http json方法封装接口
 * @createTime 2020年8月13日 15:31:22
 */
public interface FadadaApiService {

    /**
     * object转为json字符串
     *
     * @param object
     * @return
     * @throws ApiException
     */
    String toJson(Object object) throws ApiException;

    /**
     * json串 通过ParameterizedType 类型转为类（用于嵌套的类的转化）
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> T toJavaBean(String json, ParameterizedType type) throws ApiException;

    /**
     * json串转换为指定的类
     *
     * @param json
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> T toJavaBean(String json, Class<T> clzz) throws ApiException;

    /**
     * json串转为列表
     *
     * @param json
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> List<T> toList(String json, Class<T> clzz) throws ApiException;

    /**
     * http请求返回String
     *
     * @param url
     * @param method
     * @param headerMap
     * @param bodyMap
     * @param fileMap
     * @return
     * @throws ApiException
     */
    String http(String url, String method, Map<String, String> headerMap,
                Map<String, String> bodyMap, Map<String, File> fileMap) throws ApiException;

    /**
     * 文件下载
     *
     * @param url
     * @param method
     * @param headerMap
     * @param bodyMap
     * @return
     * @throws ApiException
     */
    Object httpDownLoad(String url, String method, Map<String, String> headerMap,
                        Map<String, String> bodyMap) throws ApiException;

}
