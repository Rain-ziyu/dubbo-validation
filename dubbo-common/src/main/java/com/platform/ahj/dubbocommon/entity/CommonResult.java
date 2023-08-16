package com.platform.ahj.dubbocommon.entity;

/**
 * @Description: 统一的Dubbo层返回
 * @Author: ZiYu
 * @Created on: 2023/08/15 16:22
 * @Since:
 */

import java.io.Serializable;

/**
 * Facade接口统一返回结果
 */
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = 857035909878577687L;

    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public static CommonResult fail(int code,String msg){
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.setCode(code);
        commonResult.setMsg(msg);
        return commonResult;
    }
}


