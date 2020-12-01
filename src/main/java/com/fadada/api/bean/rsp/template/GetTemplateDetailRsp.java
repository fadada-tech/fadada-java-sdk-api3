package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetTemplateDetailReq.java
 * @Description 获取模板详请响应对象
 * @Param
 * @createTime 2020年11月25日 15:02:00
 */
public class GetTemplateDetailRsp extends BaseBean {
    private String templateId;
    private String templateName;
    private String templateRemark;
    private Integer status;
    private List<TemlateFileInfo> templateFiles;
    private List<RoleInfo> roles;

    public static class TemlateFileInfo extends BaseBean {
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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateRemark() {
        return templateRemark;
    }

    public void setTemplateRemark(String templateRemark) {
        this.templateRemark = templateRemark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TemlateFileInfo> getTemplateFiles() {
        return templateFiles;
    }

    public void setTemplateFiles(List<TemlateFileInfo> templateFiles) {
        this.templateFiles = templateFiles;
    }

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
    }
}
