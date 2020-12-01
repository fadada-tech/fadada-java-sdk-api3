package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetFileBase64Req.java
 * @Description 获取文件base64值
 * @Param
 * @createTime 2020年11月25日 14:38:00
 */
public class GetFileBase64Rsp extends BaseBean {
    private String base64;

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
