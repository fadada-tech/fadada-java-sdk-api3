package com.fadada.api.bean.rsp.sign;


import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.CreateTaskByFileReq;
import com.fadada.api.bean.req.sign.file.SignerReq;
import com.fadada.api.bean.req.sign.file.SignerReqV2;
import com.fadada.api.bean.rsp.BaseRsp;
import com.fadada.api.bean.rsp.MiniProgramConfig;

import java.util.List;

/**
 * @author yh128
 * @className GetSignUrlRsp
 * @description 签署链接返回对象
 * @createTime 2020年8月13日 15:15:04
 */
public class GetSignUrlRsp extends BaseBean {

    private List<SignUrlRsp> signUrls;

    private List<SignDetailRsp> signDetails;

    private MiniProgramConfig miniProgramConfig;

    public List<SignUrlRsp> getSignUrls() {
        return signUrls;
    }

    public void setSignUrls(List<SignUrlRsp> signUrls) {
        this.signUrls = signUrls;
    }

    public MiniProgramConfig getMiniProgramConfig() {
        return miniProgramConfig;
    }

    public void setMiniProgramConfig(MiniProgramConfig miniProgramConfig) {
        this.miniProgramConfig = miniProgramConfig;
    }

    public List<SignDetailRsp> getSignDetails() {
        return signDetails;
    }

    public void setSignDetails(List<SignDetailRsp> signDetails) {
        this.signDetails = signDetails;
    }

    public static class SignDetailRsp extends BaseBean {
        private String signUrl;
        private String signOrder;
        private String signStatus;
        private SignerRsp signer;

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }

        public String getSignOrder() {
            return signOrder;
        }

        public void setSignOrder(String signOrder) {
            this.signOrder = signOrder;
        }

        public String getSignStatus() {
            return signStatus;
        }

        public void setSignStatus(String signStatus) {
            this.signStatus = signStatus;
        }

        public SignerRsp getSigner() {
            return signer;
        }

        public void setSigner(SignerRsp signer) {
            this.signer = signer;
        }
    }

    public static class SignerRsp extends BaseBean {
        private SignatoryRsp signatory;
        private CorpRsp corp;

        public SignatoryRsp getSignatory() {
            return signatory;
        }

        public void setSignatory(SignatoryRsp signatory) {
            this.signatory = signatory;
        }

        public CorpRsp getCorp() {
            return corp;
        }

        public void setCorp(CorpRsp corp) {
            this.corp = corp;
        }
    }

    public static class SignatoryRsp extends BaseBean {
        private String signerId;

        public String getSignerId() {
            return signerId;
        }

        public void setSignerId(String signerId) {
            this.signerId = signerId;
        }
    }

    public static class CorpRsp extends BaseBean {
        private String corpId;

        public String getCorpId() {
            return corpId;
        }

        public void setCorpId(String corpId) {
            this.corpId = corpId;
        }
    }


}
