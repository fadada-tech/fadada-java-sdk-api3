package com.fadada.api.bean.req.document;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className GetByDraftIdReq
 * @description 下载草稿文件请求对象
 * @createTime 2020年8月13日 15:21:11
 */
@ParamsVerif
public class GetByDraftIdReq extends BaseReq {
    /**
     * 草稿编号
     **/
    @ParamsVerif(checkNotEmpty = true)
    private String draftId;
    /**
     * 草稿文件编号
     **/
    private String draftFileId;

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getDraftFileId() {
        return draftFileId;
    }

    public void setDraftFileId(String draftFileId) {
        this.draftFileId = draftFileId;
    }
}
