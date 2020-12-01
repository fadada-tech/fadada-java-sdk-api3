package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yh128
 * @className CreateByTemplateReq
 * @description 通过模板创建任务请求对象
 * @createTime 2020年8月13日 15:20:35
 */
@ParamsVerif
public class CreateByTemplateReq extends BaseReq {

    private TemplateInfo templateInfo;

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }

    public static class TemplateInfo {
        private String templateName;
        private String templateRemark;

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
    }

    /**
     * 模板编号
     **/
    private String templateId;
    /**
     * 模板文件列表
     **/
//    @ParamsVerif
    private List<TemplateFileReq> templateFiles;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<TemplateFileReq> getTemplateFiles() {
        return templateFiles;
    }

    public void setTemplateFiles(List<TemplateFileReq> templateFiles) {
        this.templateFiles = templateFiles;
    }
}
