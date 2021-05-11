package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.4.0
 * @ClassName ChangeSignerReq.java
 * @Description 签署任务变更
 * @Param
 * @createTime 2020年10月26日 11:31:00
 */
@ParamsVerif
public class ChangeSignerReq extends BaseReq {
    @ParamsVerif
    private String taskId;
    @ParamsVerif
    private CurrentExternalSignerInfo externalSigner;
    @ParamsVerif
    private NewSignerInfo changeSigner;

    public static class CurrentExternalSignerInfo {
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    public static class NewSignerInfo {
        private String mobile;
        private String personName;
        private String idCardNo;

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

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public CurrentExternalSignerInfo getExternalSigner() {
        return externalSigner;
    }

    public void setExternalSigner(CurrentExternalSignerInfo externalSigner) {
        this.externalSigner = externalSigner;
    }

    public NewSignerInfo getChangeSigner() {
        return changeSigner;
    }

    public void setChangeSigner(NewSignerInfo changeSigner) {
        this.changeSigner = changeSigner;
    }
}
