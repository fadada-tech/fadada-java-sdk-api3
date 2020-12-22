package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetAddEmployeeUrlReq.java
 * @Description TODO
 * @Param
 * @createTime 2020年10月22日 14:29:00
 */
@ParamsVerif
public class GetAddEmployeeUrlReq extends BaseReq {
    @ParamsVerif
    private String company;
    @ParamsVerif
    private EmployeeInfo employeeInfo;
    @ParamsVerif(checkNotEmpty = true, checkUrl = true)
    private String redirectUrl;

    @ParamsVerif
    public static class EmployeeInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String unionId;

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }
    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
