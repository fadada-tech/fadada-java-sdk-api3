package com.fadada.api.bean.rsp.sign;


import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.MiniProgramConfig;

import java.util.List;

/**
 * @author yh128
 * @className GetSignUrlRsp
 * @description 签署链接返回对象
 * @createTime 2020年8月13日 15:15:04
 */
public class GetSignUrlRsp extends BaseBean {

    private List<SignUrlRsp> signUrls;


    private MiniProgramConfig miniProgramConfig;

    public List<SignUrlRsp> getSignUrls() {
        return signUrls;
    }

    public void setSignUrls(List<SignUrlRsp> signUrls) {
        this.signUrls = signUrls;
    }

    public MiniProgramConfig getMiniProgramConfig() {
        return miniProgramConfig;
    }

    public void setMiniProgramConfig(MiniProgramConfig miniProgramConfig) {
        this.miniProgramConfig = miniProgramConfig;
    }
}
