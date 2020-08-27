package com.fadada.api.bean.rsp.seal;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName SealRes.java
 * @Description 签章信息对象
 * @Param
 * @createTime 2020年06月10日 14:54:00
 */
public class SealRes extends BaseBean {
    /**
     * 签章ID
     */
    private Long sealId;

    /**
     * 审核状态:-1-审核不通过，1-待审核，2-通过
     */
    private Integer status;

    /**
     * 签章名称
     */
    private String sealName;

    /**
     * 是否是系统章:0-否，1-是
     */
    private Integer sysFlag;

    public Long getSealId() {
        return sealId;
    }

    public void setSealId(Long sealId) {
        this.sealId = sealId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSealName() {
        return sealName;
    }

    public void setSealName(String sealName) {
        this.sealName = sealName;
    }

    public Integer getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(Integer sysFlag) {
        this.sysFlag = sysFlag;
    }
}
