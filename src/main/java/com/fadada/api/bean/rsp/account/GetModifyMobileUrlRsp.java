package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.4.0
 * @ClassName GetModifyMobileUrlRsp.java
 * @Description 变更手机号码
 * @Param
 * @createTime 2021年02月01日 14:54:00
 */
public class GetModifyMobileUrlRsp extends BaseBean {

    private String modifyMobileUrl;

    public String getModifyMobileUrl() {
        return modifyMobileUrl;
    }

    public void setModifyMobileUrl(String modifyMobileUrl) {
        this.modifyMobileUrl = modifyMobileUrl;
    }
}
