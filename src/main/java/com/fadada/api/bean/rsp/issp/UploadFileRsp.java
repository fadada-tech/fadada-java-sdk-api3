package com.fadada.api.bean.rsp.issp;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName UploadFileRsp.java
 * @Description 上传文件返回uuid
 * @Param
 * @createTime 2020年09月25日 17:02:00
 */

public class UploadFileRsp extends BaseBean {
    private String fileUuid;

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }
}
