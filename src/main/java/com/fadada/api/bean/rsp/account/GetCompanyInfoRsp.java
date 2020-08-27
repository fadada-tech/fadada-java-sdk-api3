package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.vo.Applicant;
import com.fadada.api.bean.rsp.vo.BankInfo;
import com.fadada.api.bean.rsp.vo.Company;

/**
 * @author yanghui
 * @className GetCompanyInfoRsp
 * @description 获取企业信息响应对象
 * @createTime 2020年8月13日 15:09:50
 */
public class GetCompanyInfoRsp extends BaseBean {

    private String unionId;
    private String status;
    private Company companyInfo;
    private BankInfo bankInfo;
    private Applicant applicant;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Company getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Company companyInfo) {
        this.companyInfo = companyInfo;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
