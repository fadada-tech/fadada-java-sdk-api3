package com.fadada.api.bean.rsp.organization;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName GetAddEmployeeUrlReq.java
 * @Description 确定添加员工url响应对象
 * @Param
 * @createTime 2020年10月22日 14:29:00
 */
public class GetAddEmployeeUrlRsp extends BaseBean {
    private String addGroupEmployeeUrl;

    public String getAddGroupEmployeeUrl() {
        return addGroupEmployeeUrl;
    }

    public void setAddGroupEmployeeUrl(String addGroupEmployeeUrl) {
        this.addGroupEmployeeUrl = addGroupEmployeeUrl;
    }
}
