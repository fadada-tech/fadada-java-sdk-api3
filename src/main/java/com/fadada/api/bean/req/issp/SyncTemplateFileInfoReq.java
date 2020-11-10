package com.fadada.api.bean.req.issp;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

@ParamsVerif
public class SyncTemplateFileInfoReq extends BaseReq {

    @ParamsVerif(checkNotEmpty = true)
    private String fileName;

    @ParamsVerif(intContains = {1, 2})
    private Integer fileType;

    @ParamsVerif(checkNotEmpty = true)
    private String fileUuid;

    @ParamsVerif(checkNotNull = false)
    private Integer deleteStatus;

    private Long templateId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}
