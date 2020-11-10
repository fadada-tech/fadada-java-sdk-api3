package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetUserTokenReq.java
 * @Description 获取userToken请求对象
 * @Param
 * @createTime 2020年10月21日 17:08:00
 */
@ParamsVerif
public class GetUserTokenReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String grantCode;

    public String getGrantCode() {
        return grantCode;
    }

    public void setGrantCode(String grantCode) {
        this.grantCode = grantCode;
    }
}
