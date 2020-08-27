package com.fadada.api.bean.rsp;

import com.fadada.api.bean.BaseBean;
import com.fadada.api.constants.GlobalConstants;

/**
 * @author gengxl
 * @create 2020-03-06 17:41
 */
public class BaseRsp<T> extends BaseBean {

    private String code = GlobalConstants.SUCCESS_CODE;

    private String msg;

    private T data;

    public BaseRsp() {

    }

    public BaseRsp(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Boolean isSuccess() {
        return GlobalConstants.SUCCESS_CODE.equals(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
