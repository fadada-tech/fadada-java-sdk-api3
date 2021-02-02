package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName PurchaseReq.java
 * @Description 下单请求对象
 * @Param
 * @createTime 2021年02月01日 14:54:00
 */
@ParamsVerif
public class PurchaseReq extends BaseReq {

    @ParamsVerif(checkNotEmpty = true)
    private String tenantUnionId;

    @ParamsVerif(checkNotEmpty = true)
    private String tenantName;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer orderType;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer paymentType;

    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer orderWay;

    @ParamsVerif(checkNotEmpty = true)
    private String productSku;

    private Integer number = 1;

    private String oldOrderNumber;

    public String getTenantUnionId() {
        return tenantUnionId;
    }

    public void setTenantUnionId(String tenantUnionId) {
        this.tenantUnionId = tenantUnionId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getOrderWay() {
        return orderWay;
    }

    public void setOrderWay(Integer orderWay) {
        this.orderWay = orderWay;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOldOrderNumber() {
        return oldOrderNumber;
    }

    public void setOldOrderNumber(String oldOrderNumber) {
        this.oldOrderNumber = oldOrderNumber;
    }
}
