package com.platform.ahj.dobboprovider.impl;



import com.platform.ahj.dubbocommon.entity.User;
import com.platform.ahj.dubbocommon.service.UserService;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;


/**
 * @Description: 提供User的相关服务
 * @Author: ZiYu
 * @Created on: 2023/08/03 9:10
 * @Since:
 */
@DubboService(version = "1.0")
public class UserServiceImpl implements UserService {
    public String getUser(){
        return "wwl";
    }

    @Override
    public String verifyUserPhoneNumber(User user) {
        return "null";
    }

    @Override
    public StreamObserver<String> sayHelloStream(StreamObserver<String> response) {
        return null;
    }

    @Override
    public void sayHelloServerStream(String request, StreamObserver<String> response) {

    }
}
