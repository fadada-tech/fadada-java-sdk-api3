package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className GetChildCompanyListReq
 * @description 获取子公司列表请求对象
 * @createTime 2020年10月22日 14:28:28
 */
@ParamsVerif
public class GetChildCompanyListReq extends BaseReq {

    /**
     * 公司unionId，公司可以是接入方的子公司。也可以是接入方公司
     */
    @ParamsVerif(checkNotEmpty = true)
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
