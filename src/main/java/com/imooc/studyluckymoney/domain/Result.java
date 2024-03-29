package com.imooc.studyluckymoney.domain;

public class Result<T> {
    /** 错误码 */
    private Integer code;
    /** 错误信息 */
    private String message;
    /** 请求数据 */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
