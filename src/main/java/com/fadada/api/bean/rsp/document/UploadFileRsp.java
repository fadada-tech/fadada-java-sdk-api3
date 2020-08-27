package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className UploadFileRsp
 * @description 上传文件返回对象
 * @createTime 2020年8月13日 15:13:55
 */
public class UploadFileRsp extends BaseBean {

    private String fileId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
