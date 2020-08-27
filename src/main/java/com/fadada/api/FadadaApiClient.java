package com.fadada.api;

import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.exception.ApiException;

import java.io.File;
import java.util.Map;

/**
 * @author yanghui
 * @className FadadaApiClient
 * @description 请求方法
 * @createTime 2020年8月13日 15:30:37
 */
public interface FadadaApiClient {

    /**
     * 根据请求返回字符串 （无token请求）
     *
     * @param req
     * @param path
     * @return
     * @throws ApiException
     */
    String invokeAPI(BaseReq req, String path) throws ApiException;

    /**
     * 根据请求返回实体类（无token请求）
     *
     * @param req
     * @param path
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<T> invokeAPI(BaseReq req, String path, Class<T> clzz) throws ApiException;

    /**
     * 根据请求返回字符串
     *
     * @param token
     * @param req
     * @param path
     * @return
     * @throws ApiException
     */
    String invokeAPI(String token, BaseReq req, String path) throws ApiException;

    /**
     * 根据请求返回实体类
     *
     * @param token
     * @param req
     * @param path
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<T> invokeAPI(String token, BaseReq req, String path, Class<T> clzz) throws ApiException;

    /**
     * 上传文件
     *
     * @param token
     * @param req
     * @param path
     * @param files
     * @return
     * @throws ApiException
     */
    String invokeAPI(String token, BaseReq req, String path, Map<String, File> files) throws ApiException;

    /**
     * 上传文件返回实体类
     *
     * @param token
     * @param req
     * @param path
     * @param files
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<T> invokeAPI(String token, BaseReq req, String path, Map<String, File> files, Class<T> clzz) throws ApiException;

    /**
     * 下载返回对应实体类
     *
     * @param token
     * @param req
     * @param path
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<T> invokeAPIDownload(String token, BaseReq req, String path, Class<T> clzz) throws ApiException;

    /**
     * 获取封装接口 为空为设置为默认的并且返回默认的
     *
     * @return
     */
    static FadadaApiService getFadadaApiService() {
        if (FadadaApiConfig.fadadaApiService == null) {
            FadadaApiConfig.fadadaApiService = new DefaultFadadaApiServiceImpl();
        }
        return FadadaApiConfig.fadadaApiService;
    }
}
