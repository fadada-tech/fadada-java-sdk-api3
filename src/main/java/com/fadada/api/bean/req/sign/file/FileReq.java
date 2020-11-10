package com.fadada.api.bean.req.sign.file;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className FileReq
 * @description 文件信息
 * @createTime 2020年8月13日 15:23:18
 */
@ParamsVerif
public class FileReq extends BaseBean {

    private String fileId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
