package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.rsp.BaseRsp;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName PurchaseRsp.java
 * @Description 生态下单响应对象
 * @Param
 * @createTime 2021年02月01日 15:09:00
 */
public class PurchaseRsp extends BaseRsp {
    private String orderNumber;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
