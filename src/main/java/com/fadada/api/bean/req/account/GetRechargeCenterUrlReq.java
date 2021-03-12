package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

@ParamsVerif
public class GetRechargeCenterUrlReq extends BaseReq {
    @ParamsVerif(checkNotNull = false, maxLength = 255)
    private String redirectUrl;
    @ParamsVerif(checkNotNull = false, maxLength = 255)
    private String unionId;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
