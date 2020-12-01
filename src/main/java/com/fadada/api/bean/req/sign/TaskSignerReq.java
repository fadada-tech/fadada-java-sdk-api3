package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.file.SignerReq;

@ParamsVerif
public class TaskSignerReq extends BaseBean {

    @ParamsVerif(checkNotNull = false)
    private Integer signOrder;

    /**
     * 应用内部签署
     */
    @ParamsVerif(checkNotNull = false)
    private SignerReq signer;


    /**
     * 外部签署方
     */
    @ParamsVerif(checkNotNull = false)
    private ExternalSignerReq externalSigner;


    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }

    public SignerReq getSigner() {
        return signer;
    }

    public void setSigner(SignerReq signer) {
        this.signer = signer;
    }

    public ExternalSignerReq getExternalSigner() {
        return externalSigner;
    }

    public void setExternalSigner(ExternalSignerReq externalSigner) {
        this.externalSigner = externalSigner;
    }
}
