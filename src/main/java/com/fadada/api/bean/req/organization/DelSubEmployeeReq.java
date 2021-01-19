package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
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

    /**
     * 员工信息
     */
    @ParamsVerif
    private EmployeeInfo employeeInfo;

    /**
     * 员工信息
     */
    @ParamsVerif
    public static class EmployeeInfo extends BaseBean {
        /**
         * 员工unionId
         */
        @ParamsVerif(checkNotEmpty = true, maxLength = 32)
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
}
