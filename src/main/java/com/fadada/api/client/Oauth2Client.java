package com.fadada.api.client;

import com.fadada.api.FadadaApiClient;
import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.req.account.GetAuthorizeUrlReq;
import com.fadada.api.bean.req.oauth2.CancelAuthSignAuthReq;
import com.fadada.api.bean.req.oauth2.GetAutoSignAuthUrlReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.account.GetAuthorizeUrlRsp;
import com.fadada.api.bean.rsp.oauth2.AccessTokenRsp;
import com.fadada.api.bean.rsp.oauth2.GetAutoSignAuthUrlRsp;
import com.fadada.api.exception.ApiException;
import com.fadada.api.utils.PreconditionsUtil;

/**
 * @author yh128
 * @className Oauth2Client
 * @description 获取token
 * @createTime 2020年8月13日 15:32:45
 */
public class Oauth2Client {

    private static final String ACCESS_TOKEN = "POST oauth2/accessToken";
    private static final String GET_AUTHORIZE_URL_PATH = "POST oauth2/getAuthorizeUrl";
    private static final String GET_AUTO_SIGN_AUTH_URL = "POST oauth2/getAutoSignAuthUrl";
    private static final String CANCEL_AUTH_SIGN_AUTH = "POST oauth2/cancelAuthSignAuth";


    private FadadaApiClient fadadaApiClient;

    public Oauth2Client(FadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    public BaseRsp<AccessTokenRsp> getToken() throws ApiException {
        BaseReq req = new BaseReq();
        return fadadaApiClient.invokeAPI(req, ACCESS_TOKEN, AccessTokenRsp.class);
    }

    /**
     * 获取授权地址
     *
     * @param req
     * @return
     */
    public BaseRsp<GetAuthorizeUrlRsp> getAuthorizeUrl(GetAuthorizeUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_AUTHORIZE_URL_PATH, GetAuthorizeUrlRsp.class);
    }

    /**
     * 获取自动签署授权地址
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp<GetAutoSignAuthUrlRsp> getAutoSignAuthUrl(GetAutoSignAuthUrlReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, GET_AUTO_SIGN_AUTH_URL, GetAutoSignAuthUrlRsp.class);
    }

    /**
     * 取消自动签署授权
     *
     * @param req
     * @return
     * @throws ApiException
     */
    public BaseRsp cancelAuthSignAuth(CancelAuthSignAuthReq req) throws ApiException {
        PreconditionsUtil.checkObject(req);
        return fadadaApiClient.invokeAPI(req, CANCEL_AUTH_SIGN_AUTH, String.class);
    }
}
