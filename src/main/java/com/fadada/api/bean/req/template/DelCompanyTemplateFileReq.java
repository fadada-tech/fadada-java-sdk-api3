package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName DelCompanyTemplateFileReq.java
 * @Description 删除合同模板文件请求对象
 * @Param
 * @createTime 2020年07月23日 17:12:00
 */
@ParamsVerif
public class DelCompanyTemplateFileReq extends BaseReq {
    @ParamsVerif
    private TemplateInfo templateInfo;

    @ParamsVerif
    public static class TemplateInfo extends BaseBean {

        @ParamsVerif(checkNotEmpty = true)
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

    public void setTemplateIdAndFileId(String templateId, String fileId) {
        if (this.templateInfo == null) {
            this.templateInfo = new TemplateInfo();
        }
        this.templateInfo.templateId = templateId;
        this.templateInfo.fileId = fileId;
    }

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }
}
