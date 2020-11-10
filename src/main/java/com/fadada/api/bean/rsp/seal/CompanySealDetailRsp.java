package com.fadada.api.bean.rsp.seal;

import com.fadada.api.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CompanySealDetailRsp.java
 * @Description 签章详请返对象
 * @Param
 * @createTime 2020年06月17日 15:25:00
 */
public class CompanySealDetailRsp extends BaseBean {

    /**
     * 签章Id
     */
    private Long sealId;

    /**
     * 是否是系统章:0-否，1-是
     */
    private Integer sysFlag;


    /**
     * 审核状态:-1-审核不通过，1-待审核，2-通过
     */
    private Integer status;

    /**
     * 签章名称
     */
    private String sealName;

    /**
     * base64值
     */
    private String base64;

    /**
     * 签章持有人UnionId列表
     */
    private List<SealHolderUnionIdRes> sealHolders = new ArrayList<>();

    public Long getSealId() {
        return sealId;
    }

    public void setSealId(Long sealId) {
        this.sealId = sealId;
    }

    public Integer getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(Integer sysFlag) {
        this.sysFlag = sysFlag;
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

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public List<SealHolderUnionIdRes> getSealHolders() {
        return sealHolders;
    }

    public void setSealHolders(List<SealHolderUnionIdRes> sealHolders) {
        this.sealHolders = sealHolders;
    }
}
