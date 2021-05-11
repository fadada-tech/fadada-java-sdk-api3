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


    private static final String GET_FILE_BASE64 = "POST accounts/getFileBase64";
    private static final String GET_UNION_IDS = "POST accounts/getUnionIds";
    private static final String GET_MODIFY_MOBILE_URL = "POST accounts/getModifyMobileUrl";


    private static final String GET_RECHARGE_CENTER_URL = "POST accounts/getRechargeCenterUrl";
    private static final String GET_PERSON_AND_COMPANY_UNION_ID_URL = "POST accounts/getPersonAndCompanyUnionIdUrl";

    /**
     * 第三方应用操作
     */
    private static final String GET_OPEN_SERVERURL = "POST thirdUser/getOpenServerUrl";
    private static final String GET_USER_TOKEN = "POST thirdUser/getUserToken";
    private static final String CANCE_SERVER = "POST thirdUser/cancel";


    /**
     * 生态下单接口
     */
    private static final String PURCHASE = "POST order/purchase";

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

    /**
     * 根据uuid下载文件base64
     *
     * @return
     */
    public BaseRsp<GetFileBase64Rsp> getFileBase64(GetFileBase64Req req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_FILE_BASE64, GetFileBase64Rsp.class);
    }

    /**
     * 根据clientId查询unionId
     *
     * @return
     */
    public BaseRsp<GetUnionIdsRsp> getUnionIds(GetUnionIdsReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_UNION_IDS, GetUnionIdsRsp.class);
    }

    /**
     * 生态用户下单
     *
     * @return
     */
    public BaseRsp<PurchaseRsp> purchase(PurchaseReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, PURCHASE, PurchaseRsp.class);
    }


    /**
     * 手机号码变更
     *
     * @return
     */
    public BaseRsp<GetModifyMobileUrlRsp> getModifyMobileUrl(GetModifyMobileUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_MODIFY_MOBILE_URL, GetModifyMobileUrlRsp.class);
    }


    /**
     * 获取充值中心链接
     *
     * @return
     */
    public BaseRsp<GetRechargeCenterUrlRsp> getRechargeCenterUrl(GetRechargeCenterUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_RECHARGE_CENTER_URL, GetRechargeCenterUrlRsp.class);
    }

    /**
     * 获取统一个人实名+企业实名地址
     *
     * @return
     */
    public BaseRsp<GetPersonAndCompanyUnionIdUrlRsp> getPersonAndCompanyUnionIdUrl(GetPersonAndCompanyUnionIdUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_PERSON_AND_COMPANY_UNION_ID_URL, GetPersonAndCompanyUnionIdUrlRsp.class);
    }

}
