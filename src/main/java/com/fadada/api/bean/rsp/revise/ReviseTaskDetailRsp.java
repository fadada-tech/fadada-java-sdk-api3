package com.fadada.api.bean.rsp.revise;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName ReviseTaskDetailReq.java
 * @Description 定稿任务详请请求对象
 * @Param
 * @createTime 2020年11月25日 15:56:00
 */

public class ReviseTaskDetailRsp extends BaseBean {
    private String taskId;
    private String templateId;
    private String draftId;
    private String taskSubject;
    private Integer finalizeWay;
    private Integer taskStatus;
    private Integer usageStatus;
    private Integer storageMode;
    private Integer sort;
    private String expireTime;
    private List<FillRoleInfo> fillRoles;
    private List<ReviseTaskFileInfo> reviseTaskFiles;
    private List<SignRoleInfo> signRoles;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
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

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getUsageStatus() {
        return usageStatus;
    }

    public void setUsageStatus(Integer usageStatus) {
        this.usageStatus = usageStatus;
    }

    public Integer getStorageMode() {
        return storageMode;
    }

    public void setStorageMode(Integer storageMode) {
        this.storageMode = storageMode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public List<FillRoleInfo> getFillRoles() {
        return fillRoles;
    }

    public void setFillRoles(List<FillRoleInfo> fillRoles) {
        this.fillRoles = fillRoles;
    }

    public List<ReviseTaskFileInfo> getReviseTaskFiles() {
        return reviseTaskFiles;
    }

    public void setReviseTaskFiles(List<ReviseTaskFileInfo> reviseTaskFiles) {
        this.reviseTaskFiles = reviseTaskFiles;
    }

    public List<SignRoleInfo> getSignRoles() {
        return signRoles;
    }

    public void setSignRoles(List<SignRoleInfo> signRoles) {
        this.signRoles = signRoles;
    }

    public static class FillRoleInfo extends BaseBean {
        private String roleName;
        private Integer status;
        private Integer fillSort;
        private String unionId;
        private ExternalerInfo externaler;

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getFillSort() {
            return fillSort;
        }

        public void setFillSort(Integer fillSort) {
            this.fillSort = fillSort;
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
    }

    public static class ExternalerInfo extends BaseBean {
        private String mobile;
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

    public static class RoleWidgetInfo extends BaseBean {
        private String roleName;
        private List<WidgetInfo> widgets;

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public List<WidgetInfo> getWidgets() {
            return widgets;
        }

        public void setWidgets(List<WidgetInfo> widgets) {
            this.widgets = widgets;
        }
    }

    public static class WidgetInfo extends BaseBean {
        private String widgetName;
        private String widgetValue;
        private Integer type;
        private Integer isRequired;

        public String getWidgetName() {
            return widgetName;
        }

        public void setWidgetName(String widgetName) {
            this.widgetName = widgetName;
        }

        public String getWidgetValue() {
            return widgetValue;
        }

        public void setWidgetValue(String widgetValue) {
            this.widgetValue = widgetValue;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getIsRequired() {
            return isRequired;
        }

        public void setIsRequired(Integer isRequired) {
            this.isRequired = isRequired;
        }
    }

    public static class ReviseTaskFileInfo extends BaseBean {
        private String fileId;
        private String fileName;
        private String fileUuid;
        private Integer fileType;
        private List<RoleWidgetInfo> roleWidgets;

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

        public String getFileUuid() {
            return fileUuid;
        }

        public void setFileUuid(String fileUuid) {
            this.fileUuid = fileUuid;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public List<RoleWidgetInfo> getRoleWidgets() {
            return roleWidgets;
        }

        public void setRoleWidgets(List<RoleWidgetInfo> roleWidgets) {
            this.roleWidgets = roleWidgets;
        }
    }

    public static class SignRoleInfo extends BaseBean {
        private String roleName;
        private Integer roleType;
        private Integer signSort;

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public Integer getRoleType() {
            return roleType;
        }

        public void setRoleType(Integer roleType) {
            this.roleType = roleType;
        }

        public Integer getSignSort() {
            return signSort;
        }

        public void setSignSort(Integer signSort) {
            this.signSort = signSort;
        }
    }

}
