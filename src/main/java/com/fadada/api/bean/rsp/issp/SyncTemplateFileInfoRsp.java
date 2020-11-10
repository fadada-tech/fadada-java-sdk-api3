package com.fadada.api.bean.rsp.issp;

import com.fadada.api.bean.BaseBean;


public class SyncTemplateFileInfoRsp extends BaseBean {

    private Long fileId;

    private Long templateId;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}
