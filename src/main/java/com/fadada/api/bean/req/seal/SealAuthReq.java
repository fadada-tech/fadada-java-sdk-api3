package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName SealAuthReq.java
 * @Description 授权请求对象
 * @Param
 * @createTime 2020年06月17日 14:42:00
 */
@ParamsVerif
public class SealAuthReq extends BaseReq {
    @ParamsVerif
    private SealInfo sealInfo;

    @ParamsVerif
    private EmployeeInfo employeeInfo;

    @ParamsVerif(checkNotNull = false)
    private OwnerInfo owner;

    /**
     * 签章信息
     */
    @ParamsVerif
    public static class SealInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String sealId;

        public String getSealId() {
            return sealId;
        }

        public void setSealId(String sealId) {
            this.sealId = sealId;
        }
    }

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
        /**
         * 印章所属方
         */
        @ParamsVerif(checkNotNull = false, maxLength = 32)
        private String companyUnionId;

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public String getCompanyUnionId() {
            return companyUnionId;
        }

        public void setCompanyUnionId(String companyUnionId) {
            this.companyUnionId = companyUnionId;
        }
    }

    public SealInfo getSealInfo() {
        return sealInfo;
    }

    public void setSealInfo(SealInfo sealInfo) {
        this.sealInfo = sealInfo;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public OwnerInfo getOwner() {
        return owner;
    }

    public void setOwner(OwnerInfo owner) {
        this.owner = owner;
    }
}
