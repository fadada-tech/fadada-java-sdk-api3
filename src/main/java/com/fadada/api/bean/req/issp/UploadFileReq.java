package com.fadada.api.bean.req.issp;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName UploadFileReq.java
 * @Description 文件上传请求对象
 * @Param
 * @createTime 2020年09月22日 10:31:00
 */

@ParamsVerif
public class UploadFileReq extends BaseBean {
    /**
     * fileType 1合同文件,2合同附件
     */
    @ParamsVerif(intContains = {1, 2})
    private Integer fileType = 1;

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
}
