package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.4.0
 * @ClassName GetModifyMobileUrlReq.java
 * @Description 变更手机号码
 * @Param
 * @createTime 2021年02月01日 14:54:00
 */
@ParamsVerif
public class GetModifyMobileUrlReq extends BaseReq {

    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    @ParamsVerif(checkNotEmpty = true)
    private String redirectUrl;

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
}
