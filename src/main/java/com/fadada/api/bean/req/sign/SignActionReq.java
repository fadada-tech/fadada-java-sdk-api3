package com.fadada.api.bean.req.sign;


import com.fadada.api.bean.BaseBean;

public class SignActionReq extends BaseBean {

    /**
     * 签署方式 1 自动签   0 手动签
     */
    private Integer signWay;

    /**
     * 签署意愿认证方式  1 短信 2 刷脸
     */
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
