package com.fadada.api.bean.rsp.sign;

import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className SingtaskFileDetailRes
 * @description 签署文件详请
 * @createTime 2020年8月13日 15:16:48
 */
public class SingtaskFileDetailRes extends BaseBean {

    private String fileUUid;

    public String getFileUUid() {
        return fileUUid;
    }

    public void setFileUUid(String fileUUid) {
        this.fileUUid = fileUUid;
    }
}
