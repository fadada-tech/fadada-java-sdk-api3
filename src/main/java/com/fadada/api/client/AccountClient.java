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

    private static final String GET_PERSON_UNIONID_URL_PATH = "POST accounts/getPersonUnionIdUrl";
    private static final String GET_PERSON_INFO_PATH = "POST accounts/getPersonInfo";
    private static final String GET_COMPANY_UNIONID_URL_PATH = "POST accounts/getCompanyUnionIdUrl";
    private static final String GET_COMPANY_INFO_PATH = "POST accounts/getCompanyInfo";
    private static final String CHECK_ACCOUNT_INFO = "POST accounts/checkAccountInfo";
    private static final String GET_ACCESS_OBJECT_INFO = "POST accounts/getAccessObjectInfo";

    /**
     * 第三方应用操作
     */
    private static final String GET_OPEN_SERVERURL = "POST thirdUser/getOpenServerUrl";
    private static final String GET_USER_TOKEN = "POST thirdUser/getUserToken";
    private static final String CANCE_SERVER = "POST thirdUser/cancel";

    private FadadaApiClient fadadaApiClient;

    public AccountClient(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }


    /**
     * 获取个人uinonid
     *
     * @param req
     * @return
     */
    public BaseRsp<GetUnionIdUrlRsp> getPersonUnionIdUrl(GetPersonUnionIdUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_PERSON_UNIONID_URL_PATH, GetUnionIdUrlRsp.class);
    }

    /**
     * 获取个人实名信息
     *
     * @param req
     * @return
     */
    public BaseRsp<GetPersonInfoRsp> getPersonInfo(GetPersonInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_PERSON_INFO_PATH, GetPersonInfoRsp.class);
    }


    /**
     * 获取企业uinonid
     *
     * @param req
     * @return
     */
    public BaseRsp<GetUnionIdUrlRsp> getCompanyUnionIdUrl(GetCompanyUnionIdUrlReq req)
            throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_COMPANY_UNIONID_URL_PATH, GetUnionIdUrlRsp.class);
    }

    /**
     * 获取企业实名信息
     *
     * @param req
     * @return
     */
    public BaseRsp<GetCompanyInfoRsp> getCompanyInfo(GetCompanyInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_COMPANY_INFO_PATH, GetCompanyInfoRsp.class);
    }

    /**
     * 账号信息校验
     *
     * @param req
     * @return
     */
    public BaseRsp<CheckAccountInfoRsp> checkAccountInfo(CheckAccountInfoReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CHECK_ACCOUNT_INFO, CheckAccountInfoRsp.class);
    }

    /**
     * 获取接入方信息
     *
     * @param
     * @return
     */
    public BaseRsp<GetAccessObjectInfoRsp> getAccessObjectInfo(BaseReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_ACCESS_OBJECT_INFO, GetAccessObjectInfoRsp.class);
    }

    /**
     * 获取第三方授权地址
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<GetOpenServerUrlRsp> getOpenServerUrl(GetOpenServerUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_OPEN_SERVERURL, GetOpenServerUrlRsp.class);
    }

    /**
     * 获取userToken
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<GetUserTokenRsp> getUserToken(GetUserTokenReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_USER_TOKEN, GetUserTokenRsp.class);
    }

    /**
     * 取消第三方授权
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp cancelServer(CancelServerReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CANCE_SERVER, String.class);
    }
}
