package com.platform.ahj.dubbocommon.exception;

/**
 * @Description: 自定义异常
 * @Author: ZiYu
 * @Created on: 2023/08/14 14:34
 * @Since:
 */
public  class BizException  extends BaseException {
    public BizException(BaseCode code) {
        super(code);
    }



    public BizException(BaseCode code, String message) {
        super(code);
    }
}