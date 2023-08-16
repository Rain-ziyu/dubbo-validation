package com.platform.ahj.dubbocommon.exception;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/14 14:38
 * @Since:
 */
public abstract class BaseException extends RuntimeException {
    private BaseCode code;

    public BaseException(BaseCode code) {
        super(code.getCode());
        this.code = code;
    }

    public BaseCode getObjCode() {
        return this.code;
    }

    public String getCode() {
        return this.code.getCode();
    }

    public String getMsg() {
        return this.code.getDesc();
    }

    public BusinessEnum getBusinessEnum() {
        return this.code.getBusinessEnum();
    }
}

