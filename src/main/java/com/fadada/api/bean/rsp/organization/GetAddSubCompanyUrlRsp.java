package com.fadada.api.bean.rsp.organization;


import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className GetAddSubCompanyUrlRsp
 * @description 获取确认添加子公司url响应对象
 * @createTime 2020年10月26日 09:45:43
 */
public class GetAddSubCompanyUrlRsp extends BaseBean {
    private String addGroupEmployeeUrl;

    public String getAddGroupEmployeeUrl() {
        return addGroupEmployeeUrl;
    }

    public void setAddGroupEmployeeUrl(String addGroupEmployeeUrl) {
        this.addGroupEmployeeUrl = addGroupEmployeeUrl;
    }
}
