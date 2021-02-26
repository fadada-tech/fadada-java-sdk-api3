package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.CorpReq;
import com.fadada.api.bean.req.sign.ExternalSignerReq;
import com.fadada.api.bean.req.sign.SignatoryReq;
import com.fadada.api.bean.req.sign.UnlockReq;

import java.util.List;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UnlockReq.java
 * @Description 解锁
 * @Param
 * @createTime 2020年12月22日 19:13:00
 */
public class UnlockRsp extends BaseBean {

//    private ExternalSignerReq externalSigner;

    private Signer signer;

    private Integer lock;


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
