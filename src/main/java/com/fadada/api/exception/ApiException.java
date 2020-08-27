package com.fadada.api.exception;

/**
 * @author yanghui
 * @className ApiException
 * @description api异常类
 * @createTime 2020年8月13日 15:29:25
 */
public class ApiException extends Exception {
    private static final long serialVersionUID = -238091758285157331L;

    private String errMsg;

    public ApiException() {
        super();
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
