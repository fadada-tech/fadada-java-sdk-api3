package com.fadada.api.bean.rsp.seal;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName CompanySealListRsp.java
 * @Description 企业签章列表对象
 * @Param
 * @createTime 2020年06月17日 15:26:00
 */
public class CompanySealListRsp extends BaseBean {
    private List<SealRes> seals;

    public List<SealRes> getSeals() {
        return seals;
    }

    public void setSeals(List<SealRes> seals) {
        this.seals = seals;
    }
}
