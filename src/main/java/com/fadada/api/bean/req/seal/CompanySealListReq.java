package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName CompanySealList.java
 * @Description 企业签章列表请求对象
 * @Param
 * @createTime 2020年06月17日 14:43:00
 */
@ParamsVerif
public class CompanySealListReq extends BaseReq {
    @ParamsVerif
    private SealInfo sealInfo;

    /**
     * 签章信息
     */
    @ParamsVerif
    public static class SealInfo extends BaseBean {
        @ParamsVerif(intContains = {0, 1})
        private Integer loadUnPass;

        public Integer getLoadUnPass() {
            return loadUnPass;
        }

        public void setLoadUnPass(Integer loadUnPass) {
            this.loadUnPass = loadUnPass;
        }
    }

    public void setSealInfo(Integer loadUnPass) {
        if (sealInfo == null) {
            sealInfo = new SealInfo();
        }
        sealInfo.setLoadUnPass(loadUnPass);
    }

    public SealInfo getSealInfo() {
        return sealInfo;
    }

    public void setSealInfo(SealInfo sealInfo) {
        this.sealInfo = sealInfo;
    }
}
