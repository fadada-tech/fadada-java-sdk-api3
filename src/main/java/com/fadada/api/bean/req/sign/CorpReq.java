package com.fadada.api.bean.req.sign;


import com.fadada.api.bean.BaseBean;

public class CorpReq extends BaseBean {

    /**
     * 组织id
     */
    private String corpId;

    /**
     * 印章信息
     */
    private SealReq seal;

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public SealReq getSeal() {
        return seal;
    }

    public void setSeal(SealReq seal) {
        this.seal = seal;
    }
}
