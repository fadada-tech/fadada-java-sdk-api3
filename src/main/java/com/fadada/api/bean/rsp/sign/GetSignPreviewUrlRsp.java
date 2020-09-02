package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName GetSignPreviewUrlRsp.java
 * @Description 文件预览地址信息
 * @Param
 * @createTime 2020年09月01日 10:45:00
 */
public class GetSignPreviewUrlRsp extends BaseBean {
    private String signUrl;

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }
}
