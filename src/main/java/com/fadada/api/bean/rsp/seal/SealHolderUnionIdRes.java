package com.fadada.api.bean.rsp.seal;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName SealHolderUnionIdRes.java
 * @Description 持有人对象
 * @Param
 * @createTime 2020年06月10日 15:41:00
 */

public class SealHolderUnionIdRes extends BaseBean {
    private String unionId;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
