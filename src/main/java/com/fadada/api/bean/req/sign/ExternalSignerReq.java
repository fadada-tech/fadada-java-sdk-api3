package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

@ParamsVerif
public class ExternalSignerReq extends BaseBean {

    @ParamsVerif(checkNotEmpty = true, checkMobile = true)
    private String mobile;

    @ParamsVerif(maxLength = 50)
    private String personName;

    private PersonInfoReq personInfo;

    @ParamsVerif
    private ExternalCorpReq externalCorp;

    @ParamsVerif
    public static class ExternalCorpReq {
        @ParamsVerif(maxLength = 100)
        private String corpName;

        public String getCorpName() {
            return corpName;
        }

        public void setCorpName(String corpName) {
            this.corpName = corpName;
        }
    }

    @ParamsVerif
    public static class PersonInfoReq {
        private String idCardNo;

        public String getIdCardNo() {
            return idCardNo;
        }

        public void setIdCardNo(String idCardNo) {
            this.idCardNo = idCardNo;
        }
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public ExternalCorpReq getExternalCorp() {
        return externalCorp;
    }

    public void setExternalCorp(ExternalCorpReq externalCorp) {
        this.externalCorp = externalCorp;
    }

    public PersonInfoReq getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfoReq personInfo) {
        this.personInfo = personInfo;
    }
}
