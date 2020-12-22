package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;

import java.util.List;

public class GetUnionIdsRsp extends BaseBean {
    private List<UnionIdInfo> unionIdInfos;

    public static class UnionIdInfo extends BaseBean {
        private Integer identityType;
        private String unionId;
        private String name;

        public Integer getIdentityType() {
            return identityType;
        }

        public void setIdentityType(Integer identityType) {
            this.identityType = identityType;
        }

        public String getUnionId() {
            return unionId;
        }

        public void setUnionId(String unionId) {
            this.unionId = unionId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public List<UnionIdInfo> getUnionIdInfos() {
        return unionIdInfos;
    }

    public void setUnionIdInfos(List<UnionIdInfo> unionIdInfos) {
        this.unionIdInfos = unionIdInfos;
    }
}