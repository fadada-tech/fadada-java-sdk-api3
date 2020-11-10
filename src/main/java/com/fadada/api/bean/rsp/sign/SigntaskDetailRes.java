package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
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
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 姓名
     */
    private String personName;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 授权unionId
     */
    private String authorizedUnionId;
    /**
     * 签署顺序
     */
    private Integer signOrder;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAuthorizedUnionId() {
        return authorizedUnionId;
    }

    public void setAuthorizedUnionId(String authorizedUnionId) {
        this.authorizedUnionId = authorizedUnionId;
    }

    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
    }
}
