package com.fadada.api;

import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.constants.GlobalConstants;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;
import com.fadada.api.utils.config.SystemConfig;
import com.fadada.api.utils.crypt.FddCryptUtil;
import com.fadada.api.utils.date.DateUtil;
import com.fadada.api.utils.http.HttpUtil;
import com.fadada.api.utils.json.ParameterizedTypeBaseRsp;
import com.fadada.api.utils.random.UUIDGenerator;
import com.fadada.api.utils.string.StringUtil;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author yanghui
 * @className DefaultFadadaApiClient
 * @description 默认法大大api客户端
 * @createTime 2020年8月13日 15:29:41
 */
public class DefaultFadadaApiClient implements FadadaApiClient {
    private String appId;
    private String appKey;
    private String serverUrl;


    private String signType;

    public void setFadadaApiService(FadadaApiService fadadaApiService) {
        FadadaApiConfig.fadadaApiService = fadadaApiService;
    }

    public DefaultFadadaApiClient(String appId, String appKey) {
        this(appId, appKey, SystemConfig.getServerUrl());
    }

    public DefaultFadadaApiClient(String appId, String appKey, String serverUrl) {
        this(appId, appKey, serverUrl, null);
    }

    public DefaultFadadaApiClient(String appId, String appKey, String serverUrl, FadadaApiConfig fadadaApiConfig) {
        this(appId, appKey, serverUrl, fadadaApiConfig, null);
    }

    public DefaultFadadaApiClient(String appId, String appKey, String serverUrl, FadadaApiConfig fadadaApiConfig,
                                  FadadaApiService fadadaApiService) {
        this.appId = appId;
        this.appKey = appKey;
        if (StringUtil.isNotBlank(serverUrl)) {
            this.serverUrl = serverUrl;
            SystemConfig.setServerUrl(serverUrl);
        }
        if (fadadaApiConfig == null) {
            fadadaApiConfig = new FadadaApiConfig();
        }
        this.signType = fadadaApiConfig.getSignType();
        HttpUtil.CONNECT_TIMEOUT = fadadaApiConfig.getConnectTimeout();
        HttpUtil.SO_TIMEOUT = fadadaApiConfig.getReadTimeout();

        if (fadadaApiService != null) {
            setFadadaApiService(fadadaApiService);
        }
    }

    @Override
    public String invokeAPI(BaseReq req, String path) throws ApiException {
        return this.httpRequest(null, req, path, null, false);
    }

    @Override
    public <T> BaseRsp<T> invokeAPI(BaseReq req, String path, Class<T> clzz) throws ApiException {
        return this.httpRequest(null, req, path, null, false, clzz);
    }

    @Override
    public String invokeAPI(String token, BaseReq req, String path) throws ApiException {
        return this.httpRequest(token, req, path, null, true);
    }

    @Override
    public <T> BaseRsp<T> invokeAPI(String token, BaseReq req, String path, Class<T> clzz) throws ApiException {
        return this.httpRequest(token, req, path, null, true, clzz);
    }

    @Override
    public String invokeAPI(String token, BaseReq req, String path, Map<String, File> files) throws ApiException {
        return this.httpRequest(token, req, path, files, true);
    }

    @Override
    public <T> BaseRsp<T> invokeAPI(String token, BaseReq req, String path,
                                    Map<String, File> files, Class<T> clzz) throws ApiException {
        return this.httpRequest(token, req, path, files, true, clzz);
    }

    @Override
    public <T> BaseRsp<T> invokeAPIDownload(String token, BaseReq req, String path, Class<T> clzz)
            throws ApiException {
        checkParamsAndSetNonce(req, token, path, true);

        HashMap<String, String> bodyMap = getBodyMap(req);
        HashMap<String, String> headerMap = getSign(getHeaderMap(token, req.getNonce()), bodyMap);
        String method = getMethod(path);
        path = path.replace(method, "").trim();
        String url = serverUrl + path;

        Object result = FadadaApiClient.getFadadaApiService().httpDownLoad(url, method, headerMap, bodyMap);
        String resultString = null;
        if (result instanceof String) {
            resultString = result.toString();
        } else {
            resultString = FadadaApiClient.getFadadaApiService().toJson(result);
        }
        return FadadaApiClient.getFadadaApiService().toJavaBean(resultString, new ParameterizedTypeBaseRsp(clzz));
    }

    private String httpRequest(String token, BaseReq req, String path, Map<String, File> files,
                               boolean haveToken) throws ApiException {
        checkParamsAndSetNonce(req, token, path, haveToken);
        HashMap<String, String> bodyMap = null;
        if (token != null) {
            bodyMap = getBodyMap(req);
        }
        HashMap<String, String> headerMap = getSign(getHeaderMap(token, req.getNonce()), bodyMap);
        String method = getMethod(path);
        path = path.replace(method, "").trim();
        String url = serverUrl + path;
        return FadadaApiClient.getFadadaApiService().http(url, method, headerMap, bodyMap, files);

    }

    private String getMethod(String path) {
        String method = null;
        if (path.startsWith(GlobalConstants.METHOD_POST)) {
            method = GlobalConstants.METHOD_POST;
        } else if (path.startsWith(GlobalConstants.METHOD_GET)) {
            method = GlobalConstants.METHOD_GET;
        } else {
            throw new IllegalArgumentException("path值非法");
        }
        return method;
    }

    private <T> BaseRsp<T> httpRequest(String token, BaseReq req, String path, Map<String, File> files,
                                       boolean haveToken, Class<T> clzz)
            throws ApiException {
        String resultJson = this.httpRequest(token, req, path, files, haveToken);
        return FadadaApiClient.getFadadaApiService().toJavaBean(resultJson, new ParameterizedTypeBaseRsp(clzz));
    }

    private HashMap<String, String> getBodyMap(BaseReq req) throws ApiException {
        String bizContent = null;
        bizContent = FadadaApiClient.getFadadaApiService().toJson(req);

        HashMap<String, String> bodyMap = new HashMap(1);
        bodyMap.put("bizContent", bizContent);
        return bodyMap;
    }

    private void checkParamsAndSetNonce(BaseReq req, String token, String path, boolean haveToken) {
        PreconditionsUtil.checkNotNull(req, "req不能为空");
        if (haveToken) {
            PreconditionsUtil.checkNotEmpty(token, "token不能为空");
        }
        PreconditionsUtil.checkNotEmpty(path, "url不能为空");
        req.setNonce(UUIDGenerator.getUUID());
    }


    private HashMap<String, String> getSign(HashMap<String, String> headerMap, HashMap<String, String> bodyMap)
            throws ApiException {

        SortedMap<String, String> signMap = new TreeMap(headerMap);
        if (null != bodyMap) {
            signMap.putAll(bodyMap);
        }
        String sortParam = FddCryptUtil.sortParameters(signMap);
        String sign = FddCryptUtil.sign(sortParam, headerMap.get(GlobalConstants.FDD_TIMESTAMP), appKey);
        headerMap.put(GlobalConstants.FDD_API_SIGN, sign);
        return headerMap;
    }


    private HashMap<String, String> getHeaderMap(String token, String nonce) {
        HashMap<String, String> paraMap = new HashMap(8);
        paraMap.put(GlobalConstants.FDD_APPID, appId);
        paraMap.put(GlobalConstants.FDD_SIGN_TYPE, signType);
        if (token != null) {
            paraMap.put(GlobalConstants.FDD_TOKEN, token);
        } else {
            paraMap.put(GlobalConstants.FDD_GRANT_TYPE, GlobalConstants.CLIENT_CREDENTIAL);
        }
        paraMap.put(GlobalConstants.FDD_TIMESTAMP,
                DateUtil.timestamp2String(new Timestamp(System.currentTimeMillis()), 6));
        paraMap.put(GlobalConstants.FDD_NONCE, nonce);
        return paraMap;


    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

}
