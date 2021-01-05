package com.fadada.api.bean.req.sign.draft;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.ExternalSignerReq;
import com.fadada.api.bean.req.sign.NoticeReq;
import com.fadada.api.bean.req.sign.file.CreateSignTaskReq;

import java.util.List;

/**
 * 根据文件创建签署任务
 */
@ParamsVerif
public class CreateTaskByDraftIdReq extends CreateSignTaskReq {


    @ParamsVerif(checkNotEmpty = true)
    private String draftId;

    @ParamsVerif
    private List<CreateTaskSignerInfo> signers;

    public static class SignerInfo extends BaseBean {
        private SignatoryInfo signatory;
        private corpInfo corp;

        private SignActionInfo signAction;
        private NoticeReq notice;

        public SignatoryInfo getSignatory() {
            return signatory;
        }

        public void setSignatory(SignatoryInfo signatory) {
            this.signatory = signatory;
        }

        public corpInfo getCorp() {
            return corp;
        }

        public void setCorp(corpInfo corp) {
            this.corp = corp;
        }

        public SignActionInfo getSignAction() {
            return signAction;
        }

        public void setSignAction(SignActionInfo signAction) {
            this.signAction = signAction;
        }

        public NoticeReq getNotice() {
            return notice;
        }

        public void setNotice(NoticeReq notice) {
            this.notice = notice;
        }
    }

    public static class CreateTaskSignerInfo extends BaseBean {
        private String templateRoleName;
        private SignerInfo signer;
        private ExternalSignerReq externalSigner;
        private Integer signOrder;
        private Integer lock;

        public String getTemplateRoleName() {
            return templateRoleName;
        }

        public void setTemplateRoleName(String templateRoleName) {
            this.templateRoleName = templateRoleName;
        }

        public SignerInfo getSigner() {
            return signer;
        }

        public void setSigner(SignerInfo signer) {
            this.signer = signer;
        }

        public ExternalSignerReq getExternalSigner() {
            return externalSigner;
        }

        public void setExternalSigner(ExternalSignerReq externalSigner) {
            this.externalSigner = externalSigner;
        }

        public Integer getSignOrder() {
            return signOrder;
        }


        public void setSignOrder(Integer signOrder) {
            this.signOrder = signOrder;
        }

        public Integer getLock() {
            return lock;
        }

        public void setLock(Integer lock) {
            this.lock = lock;
        }
    }


    public static class SignatoryInfo extends BaseBean {
        private String signerId;

        public String getSignerId() {
            return signerId;
        }

        public void setSignerId(String signerId) {
            this.signerId = signerId;
        }
    }

    public static class SealInfo extends BaseBean {
        private String sealId;
        private SealInfo seal;

        public String getSealId() {
            return sealId;
        }

        public void setSealId(String sealId) {
            this.sealId = sealId;
        }

        public SealInfo getSeal() {
            return seal;
        }

        public void setSeal(SealInfo seal) {
            this.seal = seal;
        }
    }

    public static class corpInfo extends BaseBean {
        private String corpId;
        private SealInfo seal;

        public String getCorpId() {
            return corpId;
        }

        public void setCorpId(String corpId) {
            this.corpId = corpId;
        }

        public SealInfo getSeal() {
            return seal;
        }

        public void setSeal(SealInfo seal) {
            this.seal = seal;
        }
    }

    public static class SignActionInfo extends BaseBean {
        private Integer signWay;
        private Integer signIntendWay;

        public Integer getSignWay() {
            return signWay;
        }

        public void setSignWay(Integer signWay) {
            this.signWay = signWay;
        }

        public Integer getSignIntendWay() {
            return signIntendWay;
        }

        public void setSignIntendWay(Integer signIntendWay) {
            this.signIntendWay = signIntendWay;
        }
    }

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public List<CreateTaskSignerInfo> getSigners() {
        return signers;
    }

    public void setSigners(List<CreateTaskSignerInfo> signers) {
        this.signers = signers;
    }
}
