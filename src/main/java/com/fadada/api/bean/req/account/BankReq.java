package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BankReq.java
 * @Description 银行相关信息
 * @Param
 * @createTime 2020年08月06日 14:17:00
 */
@ParamsVerif
public class BankReq extends BaseBean {

    /**
     * 银行名称
     */
    @ParamsVerif(checkNotNull = false, maxLength = 30)
    private String bankName;
    /**
     * 支行名称
     */
    @ParamsVerif(checkNotNull = false, maxLength = 50)
    private String bandBranchName;
    /**
     * 银行卡号
     */
    @ParamsVerif(checkNotNull = false, maxLength = 30)
    private String bankCardNo;
    /**
     * 银行所在省份
     */
    @ParamsVerif(checkNotNull = false, maxLength = 10)
    private String bankProvinceName;
    /**
     * 银行所在市
     */
    @ParamsVerif(checkNotNull = false, maxLength = 16)
    private String bankCityName;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBandBranchName() {
        return bandBranchName;
    }

    public void setBandBranchName(String bandBranchName) {
        this.bandBranchName = bandBranchName;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankProvinceName() {
        return bankProvinceName;
    }

    public void setBankProvinceName(String bankProvinceName) {
        this.bankProvinceName = bankProvinceName;
    }

    public String getBankCityName() {
        return bankCityName;
    }

    public void setBankCityName(String bankCityName) {
        this.bankCityName = bankCityName;
    }
}
