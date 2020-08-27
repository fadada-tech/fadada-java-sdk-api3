package com.fadada.api.bean.rsp.sign;


import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.vo.DocumentRes;

import java.util.List;

/**
 * @author yanghui
 * @className TemplateSignTaskRsp
 * @description 模板签署信息
 * @createTime 2020年8月13日 15:17:09
 */
public class TemplateSignTaskRsp extends BaseBean {

    private String taskId;
    private List<DocumentRes> signFileIds;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<DocumentRes> getSignFileIds() {
        return signFileIds;
    }

    public void setSignFileIds(List<DocumentRes> signFileIds) {
        this.signFileIds = signFileIds;
    }
}
