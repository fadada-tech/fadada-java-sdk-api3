package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className GetAuthorizeUrlRsp
 * @description 获取授权地址返回对象
 * @createTime 2020年8月13日 15:10:38
 */
public class GetAuthorizeUrlRsp extends BaseBean {
    private String authorizeUrl;

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }
}
