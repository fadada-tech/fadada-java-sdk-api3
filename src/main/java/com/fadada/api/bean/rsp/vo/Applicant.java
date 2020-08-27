package com.fadada.api.bean.rsp.vo;

import com.fadada.api.bean.BaseBean;

/**
 * 个人实名信息
 *
 * @author gengxl
 * @create 2020-02-20 15:25
 */
public class Applicant extends BaseBean {
    private String applicantName;
    private String applicantMobile;

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }
}
