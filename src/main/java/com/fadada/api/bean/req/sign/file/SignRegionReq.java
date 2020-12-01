package com.fadada.api.bean.req.sign.file;

import com.fadada.api.annotation.ParamsVerif;

import java.util.List;

@ParamsVerif
public class SignRegionReq {


    @ParamsVerif(checkNotEmpty = true)
    private String fileId; //文件编号

    @ParamsVerif
    private List<SignHereReq> signHeres;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public List<SignHereReq> getSignHeres() {
        return signHeres;
    }

    public void setSignHeres(List<SignHereReq> signHeres) {
        this.signHeres = signHeres;
    }
}
