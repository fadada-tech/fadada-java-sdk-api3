package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CancelServerReq.java
 * @Description 取消第三方授权请求对象
 * @Param
 * @createTime 2020年10月21日 17:09:00
 */
@ParamsVerif
public class CancelServerReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;


    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
