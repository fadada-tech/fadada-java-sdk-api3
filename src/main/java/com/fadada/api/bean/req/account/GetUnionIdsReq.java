package com.fadada.api.bean.req.account;

import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName GetUnionIdsReq.java
 * @Description
 * @Param
 * @createTime 2020年12月18日 10:10:00
 */
public class GetUnionIdsReq extends BaseReq {
    private String clientId;
    private Integer identityType;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }
}
