package com.fadada.api.bean.req.seal;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CancelSealAuthReq.java
 * @Description 取消授权请求对象
 * @Param
 * @createTime 2020年06月17日 14:43:00
 */
@ParamsVerif
public class CancelSealAuthReq extends BaseReq {
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

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }
    }

    public void setSealInfo(String sealId) {
        if (sealInfo == null) {
            sealInfo = new SealInfo();
        }
        sealInfo.setSealId(sealId);
    }

    public void setEmployeeInfo(String unionId) {
        if (employeeInfo == null) {
            employeeInfo = new EmployeeInfo();
        }
        employeeInfo.setUnionId(unionId);
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

