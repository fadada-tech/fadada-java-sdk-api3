package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className DownLoadFileRsp
 * @description 下载文件返回对象
 * @createTime 2020年8月13日 15:12:11
 */
public class DownLoadFileRsp extends BaseBean {

    /**
     * application/zip    application/json   application/pdf
     */
    private String contentType;

    private byte[] fileBytes;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }
}
