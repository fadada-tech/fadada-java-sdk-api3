package com.fadada.api.bean.req.account;

import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.BaseBean;

/**
 * @author yh128
 * @className PersonReq
 * @description 个人信息
 * @createTime 2020年8月13日 15:20:19
 */
@ParamsVerif
public class PersonReq extends BaseBean {

    @ParamsVerif(checkNotNull = false, maxLength = 100)
    private String name;

    @ParamsVerif(checkNotNull = false, strContains = {"0", "1", "B", "C"})
    private String identType;

    private String identNo;

    @ParamsVerif(checkNotNull = false, checkMobile = true)
    private String mobile;


    /**
     * 需要上传身份证正反面  :0-只需要头像面 1-头像面与国徽面都需要 2-都不需要
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1, 2})
    private Integer idPhotoOptional;

    /**
     * 身份证反面照base64值
     */
    private String backIdCardImgBase64;

    /**
     * 身份证正面照base64值
     */
    private String idCardImgBase64;


    /**
     * 银行卡号（方案2,3会校验）
     */
    @ParamsVerif(checkNotNull = false, maxLength = 30)
    private String bankCardNo;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentType() {
        return identType;
    }

    public void setIdentType(String identType) {
        this.identType = identType;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIdPhotoOptional() {
        return idPhotoOptional;
    }

    public void setIdPhotoOptional(Integer idPhotoOptional) {
        this.idPhotoOptional = idPhotoOptional;
    }

    public String getBackIdCardImgBase64() {
        return backIdCardImgBase64;
    }

    public void setBackIdCardImgBase64(String backIdCardImgBase64) {
        this.backIdCardImgBase64 = backIdCardImgBase64;
    }

    public String getIdCardImgBase64() {
        return idCardImgBase64;
    }

    public void setIdCardImgBase64(String idCardImgBase64) {
        this.idCardImgBase64 = idCardImgBase64;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}
