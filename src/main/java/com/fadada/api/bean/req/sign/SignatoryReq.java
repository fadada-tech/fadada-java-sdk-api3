package com.fadada.api.bean.req.sign;


import com.fadada.api.bean.BaseBean;

public class SignatoryReq extends BaseBean {

    /**
     * 签署人unionId
     */
    private String signerId;

    /**
     * 印章信息
     */
    private SealReq seal;

    public String getSignerId() {
        return signerId;
    }

    public void setSignerId(String signerId) {
        this.signerId = signerId;
    }

    public SealReq getSeal() {
        return seal;
    }

    public void setSeal(SealReq seal) {
        this.seal = seal;
    }
}
