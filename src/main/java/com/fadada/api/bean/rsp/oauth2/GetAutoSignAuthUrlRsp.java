package com.fadada.api.bean.rsp.oauth2;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetAutoSignAuthUrlRsp.java
 * @Description 获取自动签授权响应
 * @Param
 * @createTime 2020年10月22日 13:57:00
 */
public class GetAutoSignAuthUrlRsp extends BaseBean {
    private String authorizeUrl;

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }
}
