package com.fadada.api.bean.rsp.sign.batch;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName BatchGetSignUrlRsp.java
 * @Description 批次号签署链接信息
 * @Param
 * @createTime 2020年09月10日 13:52:00
 */
public class BatchGetSignUrlRsp extends BaseBean {
    private String signUrl;

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }
}
