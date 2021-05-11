package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.sign.template.ExternalSigner;
import com.fadada.api.bean.rsp.BaseRsp;

import java.util.List;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName GetQuickSignUrlRsp.java
 * @Description 获取快捷签署响应对象
 * @Param
 * @createTime 2021年02月01日 14:38:00
 */
public class GetQuickSignUrlRsp extends BaseRsp {
    private List<SignUrlInfo> signUrls;
    private List<SignDetailRsp> signDetails;

    public static class SignUrlInfo extends BaseRsp {
        private String signUrl;

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }
    }

    public List<SignDetailRsp> getSignDetails() {
        return signDetails;
    }

    public void setSignDetails(List<SignDetailRsp> signDetails) {
        this.signDetails = signDetails;
    }

    public List<SignUrlInfo> getSignUrls() {
        return signUrls;
    }

    public void setSignUrls(List<SignUrlInfo> signUrls) {
        this.signUrls = signUrls;
    }

    public static class SignDetailRsp extends BaseBean {
        private String signUrl;
        private String signOrder;
        private String signStatus;
        private ExternalSigner externalSigner;

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }

        public String getSignOrder() {
            return signOrder;
        }

        public void setSignOrder(String signOrder) {
            this.signOrder = signOrder;
        }

        public String getSignStatus() {
            return signStatus;
        }

        public void setSignStatus(String signStatus) {
            this.signStatus = signStatus;
        }

        public ExternalSigner getExternalSigner() {
            return externalSigner;
        }

        public void setExternalSigner(ExternalSigner externalSigner) {
            this.externalSigner = externalSigner;
        }
    }


}
