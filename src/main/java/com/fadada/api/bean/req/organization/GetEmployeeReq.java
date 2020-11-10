package com.fadada.api.bean.req.organization;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className GetEmployeeReq
 * @description 获取企业员工列表请求对象
 * @createTime 2020年10月22日 14:28:46
 */
@ParamsVerif
public class GetEmployeeReq extends BaseReq {

    /**
     * 公司unionId，公司可以是接入方的子公司。也可以是接入方公司
     */
    @ParamsVerif(checkNotEmpty = true)
    private String company;

    /**
     * 支持分页查询，与size参数同时设置时才生效，此参数代表偏移量
     */
    private String offset;

    /**
     * 支持分页查询，与offset参数同时设置时才生效，此参数代表分页大小，最大100
     */
    private String size;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
