package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className NoticeReq
 * @description 通知信息
 * @createTime 2020年8月13日 15:24:52
 */
@ParamsVerif
public class NoticeReq extends BaseBean {

    @ParamsVerif(intContains = {1})
    private Integer notifyWay;

    @ParamsVerif(checkNotEmpty = true, checkMobile = true)
    private String notifyAddress;

    public Integer getNotifyWay() {
        return notifyWay;
    }

    public void setNotifyWay(Integer notifyWay) {
        this.notifyWay = notifyWay;
    }

    public String getNotifyAddress() {
        return notifyAddress;
    }

    public void setNotifyAddress(String notifyAddress) {
        this.notifyAddress = notifyAddress;
    }
}
