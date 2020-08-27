package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName UploadCompanyTemplateFileReq.java
 * @Description 企业模板上传文件请求对象
 * @Param
 * @createTime 2020年07月23日 17:12:00
 */
@ParamsVerif
public class UploadCompanyTemplateFileReq extends BaseReq {


    @ParamsVerif
    private TemplateInfo templateInfo;

    @ParamsVerif
    public static class TemplateInfo extends BaseBean {
        private String fileHash;

        @ParamsVerif(intContains = {1, 2})
        private Integer fileType;

        private String templateId;

        public String getFileHash() {
            return fileHash;
        }

        public void setFileHash(String fileHash) {
            this.fileHash = fileHash;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }
    }

    public void setFileHash(String fileHash) {
        if (this.templateInfo == null) {
            this.templateInfo = new TemplateInfo();
        }
        this.templateInfo.fileHash = fileHash;
    }

    public void setFileType(Integer fileType, String templateId) {
        if (this.templateInfo == null) {
            this.templateInfo = new TemplateInfo();
        }
        this.templateInfo.fileType = fileType;
        this.templateInfo.templateId = templateId;
    }


    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }
}
