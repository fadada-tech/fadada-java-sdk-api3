package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetSentUrlRsp.java
 * @Description 获取签署任务发起链接返回对象
 * @Param
 * @createTime 2020年06月17日 17:49:00
 */
public class GetSentUrlRsp extends BaseBean {
    private String sentUrl;

    public String getSentUrl() {
        return sentUrl;
    }

    public void setSentUrl(String sentUrl) {
        this.sentUrl = sentUrl;
    }
}
