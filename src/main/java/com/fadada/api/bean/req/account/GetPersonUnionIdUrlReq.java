package com.fadada.api.bean.req.account;


import com.fadada.api.annotation.ParamsVerif;
import com.fadada.api.bean.req.BaseReq;

/**
 * @author yh128
 * @className GetPersonUnionIdUrlReq
 * @description 获取个人unionId地址请求对象
 * @createTime 2020年8月13日 15:19:20
 */
@ParamsVerif
public class GetPersonUnionIdUrlReq extends BaseReq {
    @ParamsVerif(checkNotEmpty = true, maxLength = 64)
    private String clientId;

    @ParamsVerif(checkNotNull = false)
    private NoticeReq notice;

    /**
     * 是否允许修改个人信息
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer allowModify;

    @ParamsVerif(checkUrl = true)
    private String redirectUrl;

    @ParamsVerif(checkNotNull = false, checkUrl = true)
    private String notifyUrl;

    @ParamsVerif(checkNotNull = false)
    private PersonReq person;

    @ParamsVerif(checkNotNull = false, strContains = {"1"})
    private String authScope;

    /**
     * 验证方案  不校验 默认为1 三要素补充方案
     * 个人认证方案：
     * 0：三要素标准方案
     * 1：三要素补充方案
     * 2：四要素标准方案
     * 3：四要素补充方案
     * 4：纯三要素方案
     * 5：纯四要素方案
     * 6：三要素补充方案（人工审核版）
     * 7：四要素补充方案（人工审核版）
     * 9：二要素+人脸识别方案
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1, 2, 3, 4, 5, 6, 7, 9})
    private Integer authScheme = 1;

    /**
     * 重新实名认证状态
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer reRealName = 0;


    /**
     * 是否返回小程序参数
     */
    @ParamsVerif(checkNotNull = false, intContains = {0, 1})
    private Integer isMiniProgram = 0;


    private String modifyUrl;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public NoticeReq getNotice() {
        return notice;
    }

    public void setNotice(NoticeReq notice) {
        this.notice = notice;
    }

    public Integer getAllowModify() {
        return allowModify;
    }

    public void setAllowModify(Integer allowModify) {
        this.allowModify = allowModify;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public PersonReq getPerson() {
        return person;
    }

    public void setPerson(PersonReq person) {
        this.person = person;
    }

    public String getAuthScope() {
        return authScope;
    }

    public void setAuthScope(String authScope) {
        this.authScope = authScope;
    }

    public Integer getAuthScheme() {
        return authScheme;
    }

    public void setAuthScheme(Integer authScheme) {
        this.authScheme = authScheme;
    }

    public Integer getIsMiniProgram() {
        return isMiniProgram;
    }

    public void setIsMiniProgram(Integer isMiniProgram) {
        this.isMiniProgram = isMiniProgram;
    }

    public Integer getReRealName() {
        return reRealName;
    }

    public void setReRealName(Integer reRealName) {
        this.reRealName = reRealName;
    }

    public String getModifyUrl() {
        return modifyUrl;
    }

    public void setModifyUrl(String modifyUrl) {
        this.modifyUrl = modifyUrl;
    }
}
