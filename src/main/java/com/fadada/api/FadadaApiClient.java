package com.fadada.api;

import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.exception.ApiException;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author yh128
 * @className FadadaApiClient
 * @description 请求方法
 * @createTime 2020年8月13日 15:30:37
 */
public interface FadadaApiClient {


    /**
     * 根据请求返回字符串
     *
     * @param req
     * @param path
     * @return
     * @throws ApiException
     */
    String invokeAPI(BaseReq req, String path) throws ApiException;


    /**
     * 根据请求返回实体类
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
     * 根据请求返回实体类
     *
     * @param req
     * @param path
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<List<T>> invokeAPIList(BaseReq req, String path, Class<T> clzz) throws ApiException;

    /**
     * 上传文件
     *
     * @param req
     * @param path
     * @param files
     * @return
     * @throws ApiException
     */
    String invokeAPI(BaseReq req, String path, Map<String, File> files) throws ApiException;

    /**
     * 上传文件返回实体类
     *
     * @param req
     * @param path
     * @param files
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<T> invokeAPI(BaseReq req, String path, Map<String, File> files, Class<T> clzz) throws ApiException;

    /**
     * 下载返回对应实体类
     *
     * @param req
     * @param path
     * @param clzz
     * @param <T>
     * @return
     * @throws ApiException
     */
    <T> BaseRsp<T> invokeAPIDownload(BaseReq req, String path, Class<T> clzz) throws ApiException;

}
