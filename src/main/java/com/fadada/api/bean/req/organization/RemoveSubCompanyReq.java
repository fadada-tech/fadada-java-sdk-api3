package com.fadada.api.bean.req.organization;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

@ParamsVerif
public class RemoveSubCompanyReq extends BaseReq {
    /**
     * 公司unionId，公司可以是接入方的子公司。也可以是接入方公司
     */
    @ParamsVerif(checkNotEmpty = true)
    private String parentCompany;

    @ParamsVerif(checkNotEmpty = true)
    private String subCompany;

    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }

    public String getSubCompany() {
        return subCompany;
    }

    public void setSubCompany(String subCompany) {
        this.subCompany = subCompany;
    }
}
