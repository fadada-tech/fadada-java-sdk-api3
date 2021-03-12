package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

@ParamsVerif
public class GetPersonAndCompanyUnionIdUrlReq extends BaseReq {
    private String clientId;
    private CompanyReq company;
    private ApplicantReq applicant;
    private String allowModify;
    private String authScope;
    private NoticeReq notice;
    private String redirectUrl;
    private Integer reRealName;
    private Integer isMiniProgram = 0;


    public static class CompanyReq extends BaseBean {
        private Integer companyAuthScheme;
        private String companyName;
        private String organizationType;
        private String creditNo;
        private String legalName;
        private String creditImageBase64;
        private String authorizationFileBase64;
        private Integer applicantType;
        private BankReq bank;

        public Integer getCompanyAuthScheme() {
            return companyAuthScheme;
        }

        public void setCompanyAuthScheme(Integer companyAuthScheme) {
            this.companyAuthScheme = companyAuthScheme;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getOrganizationType() {
            return organizationType;
        }

        public void setOrganizationType(String organizationType) {
            this.organizationType = organizationType;
        }

        public String getCreditNo() {
            return creditNo;
        }

        public void setCreditNo(String creditNo) {
            this.creditNo = creditNo;
        }

        public String getLegalName() {
            return legalName;
        }

        public void setLegalName(String legalName) {
            this.legalName = legalName;
        }

        public String getCreditImageBase64() {
            return creditImageBase64;
        }

        public void setCreditImageBase64(String creditImageBase64) {
            this.creditImageBase64 = creditImageBase64;
        }

        public String getAuthorizationFileBase64() {
            return authorizationFileBase64;
        }

        public void setAuthorizationFileBase64(String authorizationFileBase64) {
            this.authorizationFileBase64 = authorizationFileBase64;
        }

        public Integer getApplicantType() {
            return applicantType;
        }

        public void setApplicantType(Integer applicantType) {
            this.applicantType = applicantType;
        }

        public BankReq getBank() {
            return bank;
        }

        public void setBank(BankReq bank) {
            this.bank = bank;
        }
    }

    public static class ApplicantReq extends BaseBean {
        private Integer authScheme;
        private String name;
        private String identType;
        private String identNo;
        private String mobile;
        private Integer idPhotoOptional;
        private String idCardImgBase64;
        private String backIdCardImgBase64;
        private String bankCardNo;

        public Integer getAuthScheme() {
            return authScheme;
        }

        public void setAuthScheme(Integer authScheme) {
            this.authScheme = authScheme;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdentType() {
            return identType;
        }

        public void setIdentType(String identType) {
            this.identType = identType;
        }

        public String getIdentNo() {
            return identNo;
        }

        public void setIdentNo(String identNo) {
            this.identNo = identNo;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Integer getIdPhotoOptional() {
            return idPhotoOptional;
        }

        public void setIdPhotoOptional(Integer idPhotoOptional) {
            this.idPhotoOptional = idPhotoOptional;
        }

        public String getIdCardImgBase64() {
            return idCardImgBase64;
        }

        public void setIdCardImgBase64(String idCardImgBase64) {
            this.idCardImgBase64 = idCardImgBase64;
        }

        public String getBackIdCardImgBase64() {
            return backIdCardImgBase64;
        }

        public void setBackIdCardImgBase64(String backIdCardImgBase64) {
            this.backIdCardImgBase64 = backIdCardImgBase64;
        }

        public String getBankCardNo() {
            return bankCardNo;
        }

        public void setBankCardNo(String bankCardNo) {
            this.bankCardNo = bankCardNo;
        }
    }

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

    public String getAllowModify() {
        return allowModify;
    }

    public void setAllowModify(String allowModify) {
        this.allowModify = allowModify;
    }

    public String getAuthScope() {
        return authScope;
    }

    public void setAuthScope(String authScope) {
        this.authScope = authScope;
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

    public Integer getReRealName() {
        return reRealName;
    }

    public void setReRealName(Integer reRealName) {
        this.reRealName = reRealName;
    }

    public Integer getIsMiniProgram() {
        return isMiniProgram;
    }

    public void setIsMiniProgram(Integer isMiniProgram) {
        this.isMiniProgram = isMiniProgram;
    }
}
