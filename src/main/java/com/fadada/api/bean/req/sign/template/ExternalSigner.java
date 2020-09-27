package com.fadada.api.bean.req.sign.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className ExternalSigner
 * @description 外部签署人
 * @createTime 2020年8月13日 15:26:38
 */
@ParamsVerif
public class ExternalSigner extends BaseBean {

    @ParamsVerif(checkNotEmpty = true, checkMobile = true)
    private String mobile;

    @ParamsVerif(checkNotNull = false, maxLength = 50)
    private String personName;

    @ParamsVerif(checkNotNull = false, maxLength = 100)
    private String companyName;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
