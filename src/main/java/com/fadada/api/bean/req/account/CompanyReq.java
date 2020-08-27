package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className CompanyReq
 * @description 企业信息
 * @createTime 2020年8月13日 15:18:13
 */
@ParamsVerif
public class CompanyReq extends BaseBean {

    @ParamsVerif(checkNotEmpty = true, maxLength = 100)
    private String companyName;

    /**
     * 统一社会信用代码
     */
    @ParamsVerif(checkNotNull = false, maxLength = 30)
    private String creditNo;

    /**
     * 机构法人名称
     */
    @ParamsVerif(checkNotNull = false, maxLength = 50)
    private String legalName;

    /**
     * 组织类型：0，企业；1，政府/事业单位；2，其他组织；3，个体工商户
     */
    @ParamsVerif(checkNotNull = false, strContains = {"0", "1", "2", "3"})
    private String organizationType;

    /**
     * 三证合一电子照base64
     */
    private String creditImageBase64;


    /**
     * 企业申请表base64
     */
    private String authorizationFileBase64;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
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
}
