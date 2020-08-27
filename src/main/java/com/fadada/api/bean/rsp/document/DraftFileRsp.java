package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;

/**
 * @author yanghui
 * @className DraftFileRsp
 * @description 草稿文件返回对象
 * @createTime 2020年8月13日 15:12:45
 */
public class DraftFileRsp extends BaseBean {

    /**
     * 草稿文件编号
     **/
    private String draftFileId;

    public String getDraftFileId() {
        return draftFileId;
    }

    public void setDraftFileId(String draftFileId) {
        this.draftFileId = draftFileId;
    }
}
