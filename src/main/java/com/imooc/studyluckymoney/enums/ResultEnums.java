package com.imooc.studyluckymoney.enums;

public enum  ResultEnums {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"交易成功"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    HIGNH_SCHOOL(102,"你应该在上高中了"),
    BIG_SCHOOL(103,"你已经在上大学了吧");
    ;

    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
