package com.fadada.api.bean.req.account;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @className GetCompanyUnionIdUrlReq
 * @description 获取企业unionId请求对象
 * @createTime 2020年8月13日 15:18:40
 */
@ParamsVerif
public class GetCompanyUnionIdUrlReq extends BaseReq {

    @ParamsVerif(maxLength = 64)
    private String clientId;

    @ParamsVerif
    private CompanyReq company;

    @ParamsVerif
    private ApplicantReq applicant;

    @ParamsVerif(checkNotNull = false)
    private BankReq bank;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

    @ParamsVerif(checkUrl = true)
    private String redirectUrl;

    @ParamsVerif(checkNotNull = false, checkUrl = true)
    private String notifyUrl;

    @ParamsVerif(checkNotNull = false, strContains = {"1"})
    private String authScope;

    /**
     * 是否允许修改企业信息
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer allowModify;

    /**
     * 企业认证方案： 默认1
     * 0：标准方案（对公打款+纸质审核+法人身份+法人授权）
     * 1：对公打款
     * 2：纸质审核
     * 3：法人身份（授权）认证
     * (管理员为法人时，只可选法人身份认证；管理员为代理人时，只可选法人授权认证)
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1, 2, 3})
    private Integer authScheme = 1;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public CompanyReq getCompany() {
        return company;
    }

    public void setCompany(CompanyReq company) {
        this.company = company;
    }

    public ApplicantReq getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantReq applicant) {
        this.applicant = applicant;
    }

    public BankReq getBank() {
        return bank;
    }

    public void setBank(BankReq bank) {
        this.bank = bank;
    }

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getAuthScope() {
        return authScope;
    }

    public void setAuthScope(String authScope) {
        this.authScope = authScope;
    }

    public Integer getAllowModify() {
        return allowModify;
    }

    public void setAllowModify(Integer allowModify) {
        this.allowModify = allowModify;
    }

    public Integer getAuthScheme() {
        return authScheme;
    }

    public void setAuthScheme(Integer authScheme) {
        this.authScheme = authScheme;
    }
}
