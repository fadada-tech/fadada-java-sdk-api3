package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName AddCompanySealReq.java
 * @Description 新增企业签章请求参数
 * @Param
 * @createTime 2020年06月17日 14:38:00
 */
@ParamsVerif
public class AddCompanySealReq extends BaseReq {
    @ParamsVerif
    private SealInfo sealInfo;

    /**
     * 签章信息
     */
    @ParamsVerif
    public static class SealInfo extends BaseBean {
        /**
         * 签章图片Hash
         */
        private String imageHash;
        /**
         * 签章名称
         */
        @ParamsVerif(maxLength = 16)
        private String sealName;

        public String getImageHash() {
            return imageHash;
        }

        public void setImageHash(String imageHash) {
            this.imageHash = imageHash;
        }

        public String getSealName() {
            return sealName;
        }

        public void setSealName(String sealName) {
            this.sealName = sealName;
        }
    }


    public void setSealInfo(String imageHash, String sealName) {
        if (this.sealInfo == null) {
            this.sealInfo = new SealInfo();
        }
        this.sealInfo.setImageHash(imageHash);
        this.sealInfo.setSealName(sealName);
    }

    public SealInfo getSealInfo() {
        return sealInfo;
    }

    public void setSealInfo(SealInfo sealInfo) {
        this.sealInfo = sealInfo;
    }

}
