package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName DelSubEmployeeReq.java
 * @Description 删除子公司员工请求对象
 * @Param
 * @createTime 2020年10月26日 10:02:00
 */
@ParamsVerif
public class DelSubEmployeeReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String company;
    @ParamsVerif(checkNotEmpty = true)
    private String employeeInfo;
    @ParamsVerif(checkNotEmpty = true)
    private String unionId;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(String employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
