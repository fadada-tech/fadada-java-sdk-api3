package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName CheckAccountInfoRsp.java
 * @Description 账户信息校验返回对象
 * @Param
 * @createTime 2020年08月17日 16:51:00
 */
public class CheckAccountInfoRsp extends BaseBean {
    private Integer match;

    public Integer getMatch() {
        return match;
    }

    public void setMatch(Integer match) {
        this.match = match;
    }
}
