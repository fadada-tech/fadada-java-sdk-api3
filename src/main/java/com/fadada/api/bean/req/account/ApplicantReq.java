package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className ApplicantReq
 * @description 申请人信息
 * @createTime 2020年8月13日 15:17:46
 */
@ParamsVerif
public class ApplicantReq extends BaseBean {

    @ParamsVerif(checkNotEmpty = true, maxLength = 32)
    private String unionId;

    /**
     * 申请人身份1：法人 2：代理人
     */
    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer applicantType;

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(Integer applicantType) {
        this.applicantType = applicantType;
    }
}
