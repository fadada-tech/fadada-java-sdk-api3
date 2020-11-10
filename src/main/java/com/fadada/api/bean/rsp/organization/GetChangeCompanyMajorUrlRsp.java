package com.fadada.api.bean.rsp.organization;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetChangeCompanyMajorUrlRsp.java
 * @Description 获取变更管理员的url响应对象
 * @Param
 * @createTime 2020年10月26日 10:37:00
 */
public class GetChangeCompanyMajorUrlRsp extends BaseBean {
    private String authorizeUrl;

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }
}
