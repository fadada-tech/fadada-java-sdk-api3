package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author gengxl
 * @create 2020-03-06 18:14
 */
@ParamsVerif
public class GetAuthorizeUrlReq extends BaseReq {
    @ParamsVerif
    private String unionId;
    @ParamsVerif
    private String redirectUrl;
    @ParamsVerif
    private String scope;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
