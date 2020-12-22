package com.fadada.api.bean.req.revise;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;
import com.fadada.api.bean.req.account.NoticeReq;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CreateReviseTaskReq.java
 * @Description 创建定稿任务请求对象
 * @Param
 * @createTime 2020年11月25日 15:55:00
 */
@ParamsVerif
public class CreateReviseTaskReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String templateId;
    @ParamsVerif(checkNotEmpty = true, maxLength = 50)
    private String taskSubject;
    @ParamsVerif(checkNotNull = false, intContains = {1})
    private Integer finalizeWay;
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer taskStatus;

    @ParamsVerif(checkNotNull = false, intContains = {1})
    private Integer sort;
    @ParamsVerif(checkNotNull = false)
    private SenderInfo sender;
    @ParamsVerif(minLength = 1)
    private List<FillRoleInfo> fillRoles;
    @ParamsVerif(checkNotNull = false)
    private List<TemplateFileInfo> templateFiles;

    @ParamsVerif
    public static class SenderInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String unionId;

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }
    }

    @ParamsVerif
    public static class ExternalerInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String mobile;
        @ParamsVerif(checkNotEmpty = true)
        private String name;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @ParamsVerif
    public static class FillTemplateFileInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String fileId;
        @ParamsVerif(checkNotEmpty = true)
        private String formFields;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getFormFields() {
            return formFields;
        }

        public void setFormFields(String formFields) {
            this.formFields = formFields;
        }
    }

    @ParamsVerif
    public static class FillRoleInfo extends BaseBean {
        @ParamsVerif(checkNotNull = false)
        private NoticeReq notice;
        @ParamsVerif(checkNotEmpty = true)
        private String roleName;

        private String unionId;
        @ParamsVerif(checkNotNull = false)
        private ExternalerInfo externaler;
        @ParamsVerif(checkNotNull = false)
        private List<FillTemplateFileInfo> fillTemplateFiles;

        public NoticeReq getNotice() {
            return notice;
        }

        public void setNotice(NoticeReq notice) {
            this.notice = notice;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public ExternalerInfo getExternaler() {
            return externaler;
        }

        public void setExternaler(ExternalerInfo externaler) {
            this.externaler = externaler;
        }

        public List<FillTemplateFileInfo> getFillTemplateFiles() {
            return fillTemplateFiles;
        }

        public void setFillTemplateFiles(List<FillTemplateFileInfo> fillTemplateFiles) {
            this.fillTemplateFiles = fillTemplateFiles;
        }
    }

    @ParamsVerif
    public static class TemplateFileInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String fileId;
        @ParamsVerif(checkNotEmpty = true)
        private String fileName;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTaskSubject() {
        return taskSubject;
    }

    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
    }

    public Integer getFinalizeWay() {
        return finalizeWay;
    }

    public void setFinalizeWay(Integer finalizeWay) {
        this.finalizeWay = finalizeWay;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public SenderInfo getSender() {
        return sender;
    }

    public void setSender(SenderInfo sender) {
        this.sender = sender;
    }

    public List<FillRoleInfo> getFillRoles() {
        return fillRoles;
    }

    public void setFillRoles(List<FillRoleInfo> fillRoles) {
        this.fillRoles = fillRoles;
    }

    public List<TemplateFileInfo> getTemplateFiles() {
        return templateFiles;
    }

    public void setTemplateFiles(List<TemplateFileInfo> templateFiles) {
        this.templateFiles = templateFiles;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }
}
