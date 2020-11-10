package com.fadada.api.bean.rsp.account;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.bean.rsp.vo.Person;

/**
 * @author yh128
 * @className GetPersonInfoRsp
 * @description 获取个人信息返回对象
 * @createTime 2020年8月13日 15:11:05
 */
public class GetPersonInfoRsp extends BaseBean {

    private String clientId;

    private String unionId;

    private Integer status;

    private Person person;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
