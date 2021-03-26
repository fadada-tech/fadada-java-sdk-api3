package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetChangeCompanyMajorUrlReq.java
 * @Description 获取变更管理员的url
 * @Param
 * @createTime 2020年10月26日 10:37:00
 */
@ParamsVerif
public class GetChangeCompanyMajorUrlReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    private String redirectUrl;

    private String newMajorUnionId;

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

    public String getNewMajorUnionId() {
        return newMajorUnionId;
    }

    public void setNewMajorUnionId(String newMajorUnionId) {
        this.newMajorUnionId = newMajorUnionId;
    }
}
