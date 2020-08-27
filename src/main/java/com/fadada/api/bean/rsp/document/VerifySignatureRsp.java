package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName VerifySignatureRsp.java
 * @Description 文件验签响应对象
 * @Param
 * @createTime 2020年07月23日 14:31:00
 */
public class VerifySignatureRsp extends BaseBean {

    private List<VerifySignatureRes> signatureInfos;

    public static class VerifySignatureRes extends BaseBean {

        private String signer;
        private String signedonTime;
        private String authority;
        private Integer timestampFlag;
        private String timestampTime;
        private Integer timestampVerifyFlag;
        private Integer integrityFlag;

        public String getSigner() {
            return signer;
        }

        public void setSigner(String signer) {
            this.signer = signer;
        }

        public String getSignedonTime() {
            return signedonTime;
        }

        public void setSignedonTime(String signedonTime) {
            this.signedonTime = signedonTime;
        }

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

        public Integer getTimestampFlag() {
            return timestampFlag;
        }

        public void setTimestampFlag(Integer timestampFlag) {
            this.timestampFlag = timestampFlag;
        }

        public String getTimestampTime() {
            return timestampTime;
        }

        public void setTimestampTime(String timestampTime) {
            this.timestampTime = timestampTime;
        }

        public Integer getTimestampVerifyFlag() {
            return timestampVerifyFlag;
        }

        public void setTimestampVerifyFlag(Integer timestampVerifyFlag) {
            this.timestampVerifyFlag = timestampVerifyFlag;
        }

        public Integer getIntegrityFlag() {
            return integrityFlag;
        }

        public void setIntegrityFlag(Integer integrityFlag) {
            this.integrityFlag = integrityFlag;
        }
    }

    public List<VerifySignatureRes> getSignatureInfos() {
        return signatureInfos;
    }

    public void setSignatureInfos(List<VerifySignatureRes> signatureInfos) {
        this.signatureInfos = signatureInfos;
    }

}
