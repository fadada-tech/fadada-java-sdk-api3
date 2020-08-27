package com.fadada.api.bean.rsp.vo;

import com.fadada.api.bean.BaseBean;

/**
 * 个人实名信息
 *
 * @author gengxl
 * @create 2020-02-20 15:25
 */
public class Person extends BaseBean {
    private String name;

    private String idCard;

    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
