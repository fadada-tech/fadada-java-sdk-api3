package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author gengxl
 * @create 2020-03-10 17:44
 */
@ParamsVerif
public class GetPersonInfoReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

}
