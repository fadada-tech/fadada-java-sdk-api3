package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.MiniProgramConfig;

/**
 * @author yanghui
 * @className GetUnionIdUrlRsp
 * @description 获取unionId地址返回对象
 * @createTime 2020年8月13日 15:11:27
 */
public class GetUnionIdUrlRsp extends BaseBean {

    private String nextUrl;

    private String clientId;

    private MiniProgramConfig miniProgramConfig;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public MiniProgramConfig getMiniProgramConfig() {
        return miniProgramConfig;
    }

    public void setMiniProgramConfig(MiniProgramConfig miniProgramConfig) {
        this.miniProgramConfig = miniProgramConfig;
    }
}
