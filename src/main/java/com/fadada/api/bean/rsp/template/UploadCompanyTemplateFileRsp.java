package com.fadada.api.bean.rsp.template;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UploadCompanyTemplateFileRsp.java
 * @Description 上传企业模板文件请求对象
 * @Param
 * @createTime 2020年07月23日 17:11:00
 */
public class UploadCompanyTemplateFileRsp extends BaseBean {
    private String templateId;
    private String fileId;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
