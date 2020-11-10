package com.fadada.api.bean.req.oauth2;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CancelAuthSignAuthReq.java
 * @Description 取消授权自动签署请求对象
 * @Param
 * @createTime 2020年10月21日 17:10:00
 */
@ParamsVerif
public class CancelAuthSignAuthReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
