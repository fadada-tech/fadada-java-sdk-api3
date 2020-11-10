package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

import java.util.Map;

/**
 * @author yh128
 * @className TemplateFileReq
 * @description 模板文件信息
 * @createTime 2020年8月13日 15:22:24
 */
@ParamsVerif
public class TemplateFileReq extends BaseBean {
    /**
     * 模板文件编号
     **/
    private String templateFileId;
    /**
     * 模板中填充组件,格式key:value
     **/
    private Map<String, String> formFields;
    /**
     * 生成的文档名称
     * ................
     **/
    private String documentFileName;

    public String getTemplateFileId() {
        return templateFileId;
    }

    public void setTemplateFileId(String templateFileId) {
        this.templateFileId = templateFileId;
    }

    public Map<String, String> getFormFields() {
        return formFields;
    }

    public void setFormFields(Map<String, String> formFields) {
        this.formFields = formFields;
    }

    public String getDocumentFileName() {
        return documentFileName;
    }

    public void setDocumentFileName(String documentFileName) {
        this.documentFileName = documentFileName;
    }
}
