package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetAccessObjectInfoRsp.java
 * @Description 获取接入方信息响应对象
 * @Param
 * @createTime 2020年09月01日 10:39:00
 */
public class GetAccessObjectInfoRsp extends BaseBean {
    /**
     * 企业unionId
     */
    private String companyUnionId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 管理员unionId
     */
    private String managerUnionId;

    /**
     * 管理员姓名
     */
    private String managerName;

    public String getCompanyUnionId() {
        return companyUnionId;
    }

    public void setCompanyUnionId(String companyUnionId) {
        this.companyUnionId = companyUnionId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getManagerUnionId() {
        return managerUnionId;
    }

    public void setManagerUnionId(String managerUnionId) {
        this.managerUnionId = managerUnionId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
