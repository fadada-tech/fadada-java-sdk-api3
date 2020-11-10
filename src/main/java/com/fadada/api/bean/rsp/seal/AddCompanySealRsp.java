package com.fadada.api.bean.rsp.seal;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName AddCompanySealRsp.java
 * @Description 上传企业签章返回对象
 * @Param
 * @createTime 2020年06月17日 15:26:00
 */
public class AddCompanySealRsp extends BaseBean {
    private Long sealId;

    public Long getSealId() {
        return sealId;
    }

    public void setSealId(Long sealId) {
        this.sealId = sealId;
    }
}
