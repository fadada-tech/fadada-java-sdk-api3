package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.rsp.BaseRsp;

public class GetRechargeCenterUrlRsp extends BaseRsp {
    private String rechargeCenterUrl;

    public String getRechargeCenterUrl() {
        return rechargeCenterUrl;
    }

    public void setRechargeCenterUrl(String rechargeCenterUrl) {
        this.rechargeCenterUrl = rechargeCenterUrl;
    }
}
