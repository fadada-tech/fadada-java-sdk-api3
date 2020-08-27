package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yanghui
 * @className CreateByTemplateReq
 * @description 通过模板创建任务请求对象
 * @createTime 2020年8月13日 15:20:35
 */
@ParamsVerif
public class CreateByTemplateReq extends BaseReq {

    /**
     * 模板编号
     **/
    @ParamsVerif
    private String templateId;
    /**
     * 模板文件列表
     **/
    @ParamsVerif
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
