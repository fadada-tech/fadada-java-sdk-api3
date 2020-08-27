package com.fadada.api.client;

import com.fadada.api.DefaultFadadaApiClient;
import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.account.AccessTokenRsp;
import com.fadada.api.exception.ApiException;

/**
 * @author yanghui
 * @className Oauth2Client
 * @description 获取token
 * @createTime 2020年8月13日 15:32:45
 */
public class Oauth2Client {
    private DefaultFadadaApiClient fadadaApiClient;

    private static final String GETAUTHORIZEURL_PATH = "POST oauth2/accessToken";

    public Oauth2Client(DefaultFadadaApiClient fadadaApiClient) {
        this.fadadaApiClient = fadadaApiClient;
    }

    public BaseRsp<AccessTokenRsp> getToken() throws ApiException {
        BaseReq req = new BaseReq();
        return fadadaApiClient.invokeAPI(req, GETAUTHORIZEURL_PATH, AccessTokenRsp.class);
    }
}
