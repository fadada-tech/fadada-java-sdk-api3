package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.CorpReq;
import com.fadada.api.bean.req.sign.ExternalSignerReq;
import com.fadada.api.bean.req.sign.SignatoryReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UnlockReq.java
 * @Description 解锁
 * @Param
 * @createTime 2020年12月22日 19:13:00
 */
public class UnlockRsp extends BaseBean {

    private ExternalSignerReq externalSigner;

    private Signer signer;

    private Integer lock;


    public static class Signer extends BaseBean {
        private SignatoryReq signatory;
        private CorpReq corp;

        public SignatoryReq getSignatory() {
            return signatory;
        }

        public void setSignatory(SignatoryReq signatory) {
            this.signatory = signatory;
        }

        public CorpReq getCorp() {
            return corp;
        }

        public void setCorp(CorpReq corp) {
            this.corp = corp;
        }
    }

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

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }
}
