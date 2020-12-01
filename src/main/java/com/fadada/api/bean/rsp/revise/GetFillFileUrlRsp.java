package com.fadada.api.bean.rsp.revise;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetFillFileUrlReq.java
 * @Description 获取填充地址响应对象
 * @Param
 * @createTime 2020年11月25日 15:55:00
 */
public class GetFillFileUrlRsp extends BaseBean {
    private String fillUrl;

    public String getFillUrl() {
        return fillUrl;
    }

    public void setFillUrl(String fillUrl) {
        this.fillUrl = fillUrl;
    }
}
