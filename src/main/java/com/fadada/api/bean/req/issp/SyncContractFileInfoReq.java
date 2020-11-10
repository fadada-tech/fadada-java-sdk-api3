package com.fadada.api.bean.req.issp;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

@ParamsVerif
public class SyncContractFileInfoReq extends BaseReq {

    @ParamsVerif(checkNotEmpty = true)
    private String fileName;

    @ParamsVerif(intContains = {1, 2})
    private Integer fileType;

    @ParamsVerif
    private String fileUuid;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer deleteStatus;

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
}
