package com.fadada.api.bean.req.oauth2;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetAutoSignAuthUrlReq.java
 * @Description 获取自动签署授权地址请求对象
 * @Param
 * @createTime 2020年10月21日 17:10:00
 */
@ParamsVerif
public class GetAutoSignAuthUrlReq extends BaseReq {
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
