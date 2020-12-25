package com.fadada.api.bean.req.sign;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UnlockReq.java
 * @Description 解锁
 * @Param
 * @createTime 2020年12月22日 19:13:00
 */
public class UnlockReq extends BaseReq {

    private String taskId;
    private List<UnlockSignerInfo> signers;

    public static class UnlockSignerInfo extends BaseBean {
        private ExternalSignerReq externalSigner;

        private Signer signer;

        public ExternalSignerReq getExternalSigner() {
            return externalSigner;
        }

        public void setExternalSigner(ExternalSignerReq externalSigner) {
            this.externalSigner = externalSigner;
        }

        public Signer getSigner() {
            return signer;
        }

        public void setSigner(Signer signer) {
            this.signer = signer;
        }
    }

    public static class Signer extends BaseBean {
        private SignatoryReq signatory;
        private CorpReq corpReq;

        public SignatoryReq getSignatory() {
            return signatory;
        }

        public void setSignatory(SignatoryReq signatory) {
            this.signatory = signatory;
        }

        public CorpReq getCorpReq() {
            return corpReq;
        }

        public void setCorpReq(CorpReq corpReq) {
            this.corpReq = corpReq;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<UnlockSignerInfo> getSigners() {
        return signers;
    }

    public void setSigners(List<UnlockSignerInfo> signers) {
        this.signers = signers;
    }
}
