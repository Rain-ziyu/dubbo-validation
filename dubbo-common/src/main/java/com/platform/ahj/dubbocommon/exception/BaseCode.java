package com.platform.ahj.dubbocommon.exception;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/14 15:40
 * @Since:
 */
public interface BaseCode  {
    String getCode();

    BusinessEnum getBusinessEnum();

    String getDesc();
}

