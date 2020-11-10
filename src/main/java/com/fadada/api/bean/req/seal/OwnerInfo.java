package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * 印章所有方信息
 */
@ParamsVerif
public class OwnerInfo extends BaseBean {
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}