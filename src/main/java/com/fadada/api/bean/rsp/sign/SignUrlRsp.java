package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className SignUrlRsp
 * @description 签署链接
 * @createTime 2020年8月13日 15:16:32
 */
public class SignUrlRsp extends BaseBean {

    private String signUrl;

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }
}
