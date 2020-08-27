package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName DelEmployeeReq.java
 * @Description 删除员工请求对象
 * @Param
 * @createTime 2020年06月17日 14:26:00
 */
@ParamsVerif
public class DelEmployeeReq extends BaseReq {
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
        @ParamsVerif(maxLength = 32)
        private String unionId;

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }
    }

    public void setEmployeeInfo(String unionId) {
        if (this.employeeInfo == null) {
            this.employeeInfo = new EmployeeInfo();
        }
        this.employeeInfo.setUnionId(unionId);
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }
}
