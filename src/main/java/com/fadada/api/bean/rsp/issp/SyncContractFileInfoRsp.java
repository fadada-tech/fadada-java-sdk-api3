package com.fadada.api.bean.rsp.issp;


import com.fadada.api.bean.BaseBean;

public class SyncContractFileInfoRsp extends BaseBean {

    private Long fileId;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
