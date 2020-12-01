package com.fadada.api.bean.rsp.vo;

import com.fadada.api.bean.BaseBean;

/**
 * 个人实名信息
 *
 * @author gengxl
 * @create 2020-02-20 15:25
 */
public class BankInfo extends BaseBean {
    private String bankName;

    private String bankDetailName;

    private String bankCardNo;

    private Integer status;

    private String enterTime;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankDetailName() {
        return bankDetailName;
    }

    public void setBankDetailName(String bankDetailName) {
        this.bankDetailName = bankDetailName;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }
}
