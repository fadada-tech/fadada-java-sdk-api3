package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className DownloadCompanyTemplateFileReq
 * @description 下载模板请求对象
 * @createTime 2020年8月14日 15:31:42
 */
@ParamsVerif
public class DownloadCompanyTemplateFileReq extends BaseReq {

    @ParamsVerif
    private TemplateInfo templateInfo;

    @ParamsVerif
    public static class TemplateInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String templateId;

        private Integer downloadWay = 1;

        public Integer getDownloadWay() {
            return downloadWay;
        }

        public void setDownloadWay(Integer downloadWay) {
            this.downloadWay = downloadWay;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }
    }

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }
}
