package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yanghui
 * @className DraftRsp
 * @description 草稿返回对象
 * @createTime 2020年8月13日 15:12:56
 */
public class DraftRsp extends BaseBean {

    /**
     * 临时任务编号
     **/
    private String draftId;
    /**
     * 临时文件对象列表
     **/
    private List<DraftFileRsp> draftFileIds;

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public List<DraftFileRsp> getDraftFileIds() {
        return draftFileIds;
    }

    public void setDraftFileIds(List<DraftFileRsp> draftFileIds) {
        this.draftFileIds = draftFileIds;
    }
}
