package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className UploadFileByUrlReq
 * @description 上传文件请求对象
 * @createTime 2020年8月13日 15:22:40
 */
@ParamsVerif
public class UploadFileByUrlReq extends BaseReq {
    private String fileName;

    @ParamsVerif(intContains = {1, 2})
    private Integer fileType; //1 合同文件  2 附件

    @ParamsVerif(checkNotEmpty = true)
    private String fileUrl;

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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
