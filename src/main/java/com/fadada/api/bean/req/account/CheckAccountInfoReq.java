package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName CheckAccountInfoReq.java
 * @Description 校验账户信息请求对象
 * @Param
 * @createTime 2020年08月17日 16:45:00
 */
@ParamsVerif
public class CheckAccountInfoReq extends BaseReq {
    @ParamsVerif(checkMobile = true, checkNotEmpty = true)
    private String mobile;

    private String personName;

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
