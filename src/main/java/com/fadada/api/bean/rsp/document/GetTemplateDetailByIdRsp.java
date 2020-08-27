package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;
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
    private Long templateId;

    public List<UnfillTemplateFile> getTemplateFiles() {
        return templateFiles;
    }

    public void setTemplateFiles(List<UnfillTemplateFile> templateFiles) {
        this.templateFiles = templateFiles;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

}
