package com.fadada.api.bean.req.organization;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

public class BatchSyncEmployeeReq extends BaseReq {

    private String unionId;

    private List<EmployeeInfo> employeeInfos;

    public static class EmployeeInfo extends BaseBean {
        private String employeeName;
        private String mobile;
        private String email;
        private Integer action;

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAction() {
            return action;
        }

        public void setAction(Integer action) {
            this.action = action;
        }
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public List<EmployeeInfo> getEmployeeInfos() {
        return employeeInfos;
    }

    public void setEmployeeInfos(List<EmployeeInfo> employeeInfos) {
        this.employeeInfos = employeeInfos;
    }
}
