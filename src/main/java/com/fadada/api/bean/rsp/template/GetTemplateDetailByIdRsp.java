package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.document.TemplateTargetRsp;
import com.fadada.api.bean.rsp.vo.UnfillTemplateFile;

import java.util.List;

/**
 * @author yanghui
 * @className GetTemplateDetailByIdRsp
 * @description 模板详请返回对象
 * @createTime 2020年8月13日 15:13:25
 */
public class GetTemplateDetailByIdRsp extends BaseBean {

    /**
     * 模板文件列表
     **/
    private List<UnfillTemplateFile> templateFiles;
    /**
     * 任务编号
     **/
    private String templateId;

    private List<TemplateTargetRsp> targets;

    private String templateName;

    private Integer sortType;

    private String templateRemark;

    private Integer templateStatus;

    public List<UnfillTemplateFile> getTemplateFiles() {
        return templateFiles;
    }

    public void setTemplateFiles(List<UnfillTemplateFile> templateFiles) {
        this.templateFiles = templateFiles;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<TemplateTargetRsp> getTargets() {
        return targets;
    }

    public void setTargets(List<TemplateTargetRsp> targets) {
        this.targets = targets;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public String getTemplateRemark() {
        return templateRemark;
    }

    public void setTemplateRemark(String templateRemark) {
        this.templateRemark = templateRemark;
    }

    public Integer getTemplateStatus() {
        return templateStatus;
    }

    public void setTemplateStatus(Integer templateStatus) {
        this.templateStatus = templateStatus;
    }
}
