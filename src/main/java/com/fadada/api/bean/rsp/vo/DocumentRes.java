package com.fadada.api.bean.rsp.vo;

import com.fadada.api.bean.BaseBean;

/**
 * @author gengxl
 */
public class DocumentRes extends BaseBean {
    private String signFileId;

    public String getSignFileId() {
        return signFileId;
    }

    public void setSignFileId(String signFileId) {
        this.signFileId = signFileId;
    }
}
