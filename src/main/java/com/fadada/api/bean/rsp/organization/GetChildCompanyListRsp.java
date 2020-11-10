package com.fadada.api.bean.rsp.organization;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className GetChildCompanyListReq
 * @description 获取子公司列表响应对象
 * @createTime 2020年10月22日 14:28:28
 */
public class GetChildCompanyListRsp extends BaseBean {

    private String companyName;

    private String directCompanyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDirectCompanyName() {
        return directCompanyName;
    }

    public void setDirectCompanyName(String directCompanyName) {
        this.directCompanyName = directCompanyName;
    }
}
