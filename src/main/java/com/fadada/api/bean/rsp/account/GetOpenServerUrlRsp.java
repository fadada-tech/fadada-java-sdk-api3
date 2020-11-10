package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetOpenServerUrlRsp.java
 * @Description 获取第三方授权地址响应
 * @Param
 * @createTime 2020年10月21日 17:07:00
 */

public class GetOpenServerUrlRsp extends BaseBean {
    private String openServerUrl;

    public String getOpenServerUrl() {
        return openServerUrl;
    }

    public void setOpenServerUrl(String openServerUrl) {
        this.openServerUrl = openServerUrl;
    }
}
