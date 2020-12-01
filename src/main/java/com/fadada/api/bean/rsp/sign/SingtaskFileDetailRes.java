package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className SingtaskFileDetailRes
 * @description 签署文件详请
 * @createTime 2020年8月13日 15:16:48
 */
public class SingtaskFileDetailRes extends BaseBean {

    private String fileUUid;
    private String fileId;
    private String fileName;
    private Integer fileType;

    public String getFileUUid() {
        return fileUUid;
    }

    public void setFileUUid(String fileUUid) {
        this.fileUUid = fileUUid;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

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
}
