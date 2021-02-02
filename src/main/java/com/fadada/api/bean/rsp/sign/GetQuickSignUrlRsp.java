package com.fadada.api.bean.rsp.sign;

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

    public static class SignUrlInfo extends BaseRsp {
        private String signUrl;

        public String getSignUrl() {
            return signUrl;
        }

        public void setSignUrl(String signUrl) {
            this.signUrl = signUrl;
        }
    }

    public List<SignUrlInfo> getSignUrls() {
        return signUrls;
    }

    public void setSignUrls(List<SignUrlInfo> signUrls) {
        this.signUrls = signUrls;
    }
}
