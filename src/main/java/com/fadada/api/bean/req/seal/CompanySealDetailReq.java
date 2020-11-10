package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CompanySealDetailReq.java
 * @Description 企业签章详请请求对象
 * @Param
 * @createTime 2020年06月17日 14:43:00
 */
@ParamsVerif
public class CompanySealDetailReq extends BaseReq {


    @ParamsVerif
    private SealInfo sealInfo;

    @ParamsVerif(checkNotNull = false)
    private OwnerInfo owner;

    /**
     * 签章信息
     */
    @ParamsVerif
    public static class SealInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String sealId;

        public String getSealId() {
            return sealId;
        }

        public void setSealId(String sealId) {
            this.sealId = sealId;
        }
    }

    public SealInfo getSealInfo() {
        return sealInfo;
    }

    public void setSealInfo(SealInfo sealInfo) {
        this.sealInfo = sealInfo;
    }

    public OwnerInfo getOwner() {
        return owner;
    }

    public void setOwner(OwnerInfo owner) {
        this.owner = owner;
    }
}
