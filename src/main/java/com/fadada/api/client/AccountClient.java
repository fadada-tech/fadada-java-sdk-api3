package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.req.account.*;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.account.*;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author gengxl
 * @create 2020-03-07 9:43
 */
public class AccountClient {
    private static final String GET_AUTHORIZE_URL_PATH = "POST /oauth2/getAuthorizeUrl";

    private static final String GET_PERSON_UNIONID_URL_PATH = "POST /accounts/getPersonUnionIdUrl";
    private static final String GET_PERSON_INFO_PATH = "POST /accounts/getPersonInfo";
    private static final String GET_COMPANY_UNIONID_URL_PATH = "POST /accounts/getCompanyUnionIdUrl";
    private static final String GET_COMPANY_INFO_PATH = "POST /accounts/getCompanyInfo";
    private static final String CHECK_ACCOUNT_INFO = "POST /accounts/checkAccountInfo";
    private static final String GET_ACCESS_OBJECT_INFO = "POST /accounts/getAccessObjectInfo";

    private FadadaApiClient fadadaApiClient;

    public AccountClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    /**
     * 获取授权地址
     *
     * @param req
     * @return
     */
    public BaseRsp<GetAuthorizeUrlRsp> getAuthorizeUrl(String token, GetAuthorizeUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_AUTHORIZE_URL_PATH, GetAuthorizeUrlRsp.class);
    }

    /**
     * 获取个人uinonid
     *
     * @param req
     * @return
     */
    public BaseRsp<GetUnionIdUrlRsp> getPersonUnionIdUrl(String token, GetPersonUnionIdUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_PERSON_UNIONID_URL_PATH, GetUnionIdUrlRsp.class);
    }

    /**
     * 获取个人实名信息
     *
     * @param req
     * @return
     */
    public BaseRsp<GetPersonInfoRsp> getPersonInfo(String token, GetPersonInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_PERSON_INFO_PATH, GetPersonInfoRsp.class);
    }


    /**
     * 获取企业uinonid
     *
     * @param req
     * @return
     */
    public BaseRsp<GetUnionIdUrlRsp> getCompanyUnionIdUrl(String token, GetCompanyUnionIdUrlReq req)
            throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_COMPANY_UNIONID_URL_PATH, GetUnionIdUrlRsp.class);
    }

    /**
     * 获取企业实名信息
     *
     * @param req
     * @return
     */
    public BaseRsp<GetCompanyInfoRsp> getCompanyInfo(String token, GetCompanyInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, GET_COMPANY_INFO_PATH, GetCompanyInfoRsp.class);
    }

    /**
     * 账号信息校验
     *
     * @param req
     * @return
     */
    public BaseRsp<CheckAccountInfoRsp> checkAccountInfo(String token, CheckAccountInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(token, req, CHECK_ACCOUNT_INFO, CheckAccountInfoRsp.class);
    }

    /**
     * 获取接入方信息
     *
     * @param
     * @return
     */
    public BaseRsp<GetAccessObjectInfoRsp> getAccessObjectInfo(String token) throws ApiException {
        return fadadaApiClient.invokeAPI(token, new BaseReq(), GET_ACCESS_OBJECT_INFO, GetAccessObjectInfoRsp.class);
    }
}
