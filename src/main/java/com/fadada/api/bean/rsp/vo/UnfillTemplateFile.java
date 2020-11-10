package com.fadada.api.bean.rsp.vo;

import com.fadada.api.bean.BaseBean;

import java.util.List;
import java.util.Map;

/**
 * @author yh128
 * @className UnfillTemplateFile
 * @description 未填充模板信息
 * @createTime 2020年8月13日 15:34:09
 */
public class UnfillTemplateFile extends BaseBean {
    /**
     * 模板文件编号
     **/
    private Long templateFileId;
    /**
     * 模板文件包含的控件对象列表
     **/
    private List<Map<String, Object>> widgets;

    public Long getTemplateFileId() {
        return templateFileId;
    }

    public void setTemplateFileId(Long templateFileId) {
        this.templateFileId = templateFileId;
    }

    public List<Map<String, Object>> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Map<String, Object>> widgets) {
        this.widgets = widgets;
    }
}
