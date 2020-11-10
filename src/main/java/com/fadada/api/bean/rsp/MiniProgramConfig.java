package com.fadada.api.bean.rsp;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName MiniProgramConfig.java
 * @Description 小程序配置信息
 * @Param
 * @createTime 2020年08月18日 17:51:00
 */
public class MiniProgramConfig extends BaseBean {

    private String appId;
    private String path;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
