package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
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

    /**
     * 签章信息
     */
    @ParamsVerif
    public static class SealInfo extends BaseBean {
        @ParamsVerif
        private Long sealId;

        public Long getSealId() {
            return sealId;
        }

        public void setSealId(Long sealId) {
            this.sealId = sealId;
        }
    }

    public void setSealInfo(Long sealId) {
        if (sealInfo == null) {
            sealInfo = new SealInfo();
        }
        sealInfo.setSealId(sealId);
    }

    public SealInfo getSealInfo() {
        return sealInfo;
    }

    public void setSealInfo(SealInfo sealInfo) {
        this.sealInfo = sealInfo;
    }
}
