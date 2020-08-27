package com.fadada.api.bean.rsp.vo;

import com.fadada.api.bean.BaseBean;

/**
 * 个人实名信息
 *
 * @author gengxl
 * @create 2020-02-20 15:25
 */
public class Company extends BaseBean {
    private String companyName;
    private String organizationCard;
    private String authenticateStatus;
    private String organizationType;
    private String hasAgent;
    private String legalName;
    private String legal;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrganizationCard() {
        return organizationCard;
    }

    public void setOrganizationCard(String organizationCard) {
        this.organizationCard = organizationCard;
    }

    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    public void setAuthenticateStatus(String authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getHasAgent() {
        return hasAgent;
    }

    public void setHasAgent(String hasAgent) {
        this.hasAgent = hasAgent;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }
}
