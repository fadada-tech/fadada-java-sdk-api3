package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className AccessTokenRsp
 * @description 获取token返回对象
 * @createTime 2020年8月13日 15:10:13
 */
public class AccessTokenRsp extends BaseBean {

    private String accessToken;

    /**
     * 有效期截至时间(毫秒)
     */
    private String expiresIn;
    /**
     * 有效期截至时间
     */
    private String expiresTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(String expiresTime) {
        this.expiresTime = expiresTime;
    }

}
