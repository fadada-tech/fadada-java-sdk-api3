package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className ApplicantReq
 * @description 申请人信息
 * @createTime 2020年8月13日 15:17:46
 */
@ParamsVerif
public class ApplicantReq extends BaseBean {

    @ParamsVerif(maxLength = 32)
    private String unionId;

    /**
     * 申请人身份1：法人 2：代理人 如果type为2时生效，默认为1
     */
    @ParamsVerif(checkNotNull = false, intContains = {1, 2})
    private Integer applicantType = 1;

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
