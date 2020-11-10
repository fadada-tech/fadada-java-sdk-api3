package com.fadada.api.bean.req.sign.file;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @className FileSignReq
 * @description 文件签署信息
 * @createTime 2020年8月13日 15:23:34
 */
@ParamsVerif
public class FileSignReq extends BaseBean {
    /**
     * 文件编号
     */
    @ParamsVerif(checkNotEmpty = true, maxLength = 20)
    private String fileId;
    /**
     * 签署位置
     */
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
