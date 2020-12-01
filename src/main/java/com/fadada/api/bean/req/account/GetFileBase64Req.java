package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetFileBase64Req.java
 * @Description 获取文件base64值
 * @Param
 * @createTime 2020年11月25日 14:38:00
 */
@ParamsVerif
public class GetFileBase64Req extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
