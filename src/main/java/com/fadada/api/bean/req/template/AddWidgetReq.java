package com.fadada.api.bean.req.template;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yanghui
 * @version 1.0.0
 * @ClassName AddWidgetReq.java
 * @Description 新增控件请求对象
 * @Param
 * @createTime 2021年01月05日 10:37:00
 */
@ParamsVerif
public class AddWidgetReq extends BaseReq {

    @ParamsVerif(minValue = "1", maxValue = "3")
    private Integer widgetType;
    @ParamsVerif(checkNotEmpty = true, maxLength = 16)
    private String widgetName;
    private String widgetValue;
    @ParamsVerif(intContains = {0, 1, 2, 3, 6})
    private Integer fontType;
    @ParamsVerif(minValue = "12", maxValue = "27")
    private Integer fontSize;
    @ParamsVerif(minValue = "1", maxValue = "3")
    private Integer align;
    @ParamsVerif(intContains = {1, 2})
    private Integer isRequired;

    public Integer getWidgetType() {
        return widgetType;
    }

    public void setWidgetType(Integer widgetType) {
        this.widgetType = widgetType;
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    public String getWidgetValue() {
        return widgetValue;
    }

    public void setWidgetValue(String widgetValue) {
        this.widgetValue = widgetValue;
    }

    public Integer getFontType() {
        return fontType;
    }

    public void setFontType(Integer fontType) {
        this.fontType = fontType;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Integer getAlign() {
        return align;
    }

    public void setAlign(Integer align) {
        this.align = align;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }
}


