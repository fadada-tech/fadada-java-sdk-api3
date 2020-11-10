package com.fadada.api.bean.rsp.organization;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className GetEmployeeReq
 * @description 获取企业员工列表响应对象
 * @createTime 2020年10月22日 14:28:46
 */

public class GetEmployeeRsp extends BaseBean {
    private String name;
    private String mobile;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
