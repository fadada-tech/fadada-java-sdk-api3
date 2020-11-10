package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName VerifySignatureReq.java
 * @Description 合同文件验签请求对象
 * @Param
 * @createTime 2020年07月23日 14:41:00
 */
@ParamsVerif
public class VerifySignatureReq extends BaseReq {
    private PdfInfo pdfInfo;


    public static class PdfInfo extends BaseBean {

        private String fileHash;

        public String getFileHash() {
            return fileHash;
        }

        public void setFileHash(String fileHash) {
            this.fileHash = fileHash;
        }
    }

    public PdfInfo getPdfInfo() {
        return pdfInfo;
    }

    public void setPdfInfo(PdfInfo pdfInfo) {
        this.pdfInfo = pdfInfo;
    }

    public void setFileHash(String fileHash) {
        if (this.pdfInfo == null) {
            this.pdfInfo = new PdfInfo();
        }
        this.pdfInfo.fileHash = fileHash;
    }
}
