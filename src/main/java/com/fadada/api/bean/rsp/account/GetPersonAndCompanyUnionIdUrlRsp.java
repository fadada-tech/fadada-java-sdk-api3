package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.rsp.BaseRsp;

public class GetPersonAndCompanyUnionIdUrlRsp extends BaseRsp {
    private String nextUrl;
    private String clientId;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
