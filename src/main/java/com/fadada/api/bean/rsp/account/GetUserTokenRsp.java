package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetUserTokenRsp.java
 * @Description 获取userToken返回对象
 * @Param
 * @createTime 2020年10月21日 17:08:00
 */
public class GetUserTokenRsp extends BaseReq {
    private String userToken;

    @Override
    public String getUserToken() {
        return userToken;
    }

    @Override
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
