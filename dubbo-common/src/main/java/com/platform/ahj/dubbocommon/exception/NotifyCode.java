package com.platform.ahj.dubbocommon.exception;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/14 15:44
 * @Since:
 */

public enum NotifyCode implements BaseCode {
    DUP("94001", "数据重复"),
    INVALID_PARAM("940042", "校验参数错误");


    private String code;
    private String desc;

    NotifyCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public String getCode() {
        return code;
    }


    /**
     * @return
     */
    @Override
    public BusinessEnum getBusinessEnum() {
        return BusinessEnum.COMMON;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
