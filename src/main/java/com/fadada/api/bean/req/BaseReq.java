package com.fadada.api.bean.req;

import com.fadada.api.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gengxl
 * @create 2020-03-06 18:03
 */
public class BaseReq extends BaseBean {
    @JsonIgnore
    private String token;
    @JsonIgnore
    private String userToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
