package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @className UploadFileReq
 * @description 上传文件请求对象
 * @createTime 2020年8月13日 15:22:40
 */
@ParamsVerif
public class UploadFileReq extends BaseReq {
    /**
     * 1 合同文件  2 附件
     */
    @ParamsVerif
    private Integer fileType;

    /**
     * 文件hash值
     */
    private String fileContentHash;

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileContentHash() {
        return fileContentHash;
    }

    public void setFileContentHash(String fileContentHash) {
        this.fileContentHash = fileContentHash;
    }
}
