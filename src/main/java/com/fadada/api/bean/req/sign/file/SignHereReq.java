package com.fadada.api.bean.req.sign.file;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className SignHereReq
 * @description 签署位置信息
 * @createTime 2020年8月13日 15:33:35
 */
@ParamsVerif
public class SignHereReq extends BaseBean {

    @ParamsVerif
    private Integer pageNumber;
    @ParamsVerif
    private Double xCoordinate;
    @ParamsVerif
    private Double yCoordinate;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
