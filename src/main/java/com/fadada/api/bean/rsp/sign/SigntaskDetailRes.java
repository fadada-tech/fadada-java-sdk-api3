package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className SigntaskDetailRes
 * @description 签署任务信息
 * @createTime 2020年8月13日 15:33:47
 */
public class SigntaskDetailRes extends BaseBean {
    /**
     * 法大大用户唯一标识
     **/
    private String unionId;
    /**
     * 签署结果：0待签，1已签
     **/
    private Integer signStatus;
    /**
     * 签署结果描述
     **/
    private String resultDesc;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
