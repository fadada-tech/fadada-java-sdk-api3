package com.fadada.api.bean.rsp.document;

import com.fadada.api.bean.BaseBean;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName LookUpCoordinatesRsp.java
 * @Description 关键字坐标查询响应对象
 * @Param
 * @createTime 2020年07月23日 14:31:00
 */
public class LookUpCoordinatesRsp extends BaseBean {

    private List<LookUpCoordinatesRes> coordinates;

    public static class LookUpCoordinatesRes extends BaseBean {

        private Integer pageNumber;
        private Double xCoordinate;
        private Double yCoordinate;

        public Integer getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
        }

        public Double getxCoordinate() {
            return xCoordinate;
        }

        public void setxCoordinate(Double xCoordinate) {
            this.xCoordinate = xCoordinate;
        }

        public Double getyCoordinate() {
            return yCoordinate;
        }

        public void setyCoordinate(Double yCoordinate) {
            this.yCoordinate = yCoordinate;
        }
    }

    public List<LookUpCoordinatesRes> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<LookUpCoordinatesRes> coordinates) {
        this.coordinates = coordinates;
    }
}
