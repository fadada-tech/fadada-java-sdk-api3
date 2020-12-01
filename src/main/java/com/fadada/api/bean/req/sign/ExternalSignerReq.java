package com.fadada.api.bean.req.sign;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

@ParamsVerif
public class ExternalSignerReq extends BaseBean {

    @ParamsVerif(checkNotEmpty = true, checkMobile = true)
    private String mobile;

    @ParamsVerif(maxLength = 50)
    private String personName;

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
}
