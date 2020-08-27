package com.fadada.api.bean.req;

import com.fadada.api.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gengxl
 * @create 2020-03-06 18:03
 */
public class BaseReq extends BaseBean {
    @JsonIgnore
    private String nonce;
    @JsonIgnore
    private String token;

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
