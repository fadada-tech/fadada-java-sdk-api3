package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className NoticeReq
 * @description 发送短信请求对象
 * @createTime 2020年8月13日 15:20:00
 */
@ParamsVerif
public class NoticeReq extends BaseBean {
    /**
     * 通知方式：1 短信，2 邮箱
     */
    @ParamsVerif(intContains = {1})
    private Integer notifyWay;
    /**
     * 手机号
     */
    @ParamsVerif(checkNotEmpty = true)
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
