package com.fadada.api.bean.req.revise;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.req.BaseReq;

import java.util.List;

/**
 * @author yh128
 * @version 1.0.0
 * @ClassName SaveFillValuesReq.java
 * @Description 填充值请求对象
 * @Param
 * @createTime 2020年11月25日 15:56:00
 */
@ParamsVerif
public class SaveFillValuesReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true)
    private String taskId;
    @ParamsVerif(minLength = 1)
    private List<RoleFillValueInfo> roleFillValues;

    @ParamsVerif
    public static class RoleFillValueInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String roleName;
        @ParamsVerif(minLength = 1)
        private List<FillValueInfo> fillValues;

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public List<FillValueInfo> getFillValues() {
            return fillValues;
        }

        public void setFillValues(List<FillValueInfo> fillValues) {
            this.fillValues = fillValues;
        }
    }

    @ParamsVerif
    public static class FillValueInfo extends BaseBean {
        @ParamsVerif(checkNotEmpty = true)
        private String fileId;
        @ParamsVerif(checkNotEmpty = true)
        private String values;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }

        public String getValues() {
            return values;
        }

        public void setValues(String values) {
            this.values = values;
        }
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<RoleFillValueInfo> getRoleFillValues() {
        return roleFillValues;
    }

    public void setRoleFillValues(List<RoleFillValueInfo> roleFillValues) {
        this.roleFillValues = roleFillValues;
    }
}
