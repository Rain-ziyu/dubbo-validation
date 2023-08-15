package com.platform.ahj.dobboprovider.impl;


import com.platform.ahj.dubbocommon.entity.User;
import com.platform.ahj.dubbocommon.exception.BizException;
import com.platform.ahj.dubbocommon.exception.NotifyCode;
import com.platform.ahj.dubbocommon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboService;

@Slf4j
/**
 * @Description: 提供User的相关服务
 * @Author: ZiYu
 * @Created on: 2023/08/03 9:10
 * @Since:
 */
@DubboService(version = "2.0"
         ,validation = "true"   //服务端序校验出现的异常无法传递至客户端
)
public class UserServiceImpl implements UserService {
    public String getUser(User user) {
        return "wwl1";
    }
    public String setUser(User user) {
        return "wwl1";
    }
    @Override
    public String verifyUserPhoneNumber(User user) {
        // 测试抛出的自定义异常是否正常反序列化至调用方
        throw    new BizException(NotifyCode.DUP) ;
        // throw  new RuntimeException("hhhh");
    }

    @Override
    public StreamObserver<String> sayHelloStream(StreamObserver<String> response) {
        return new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                log.info("服务端接受的客户端的内容："+data);
                response.onNext("响应结果:"+data);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                log.info("接收完成");
            }
        };
    }

    @Override
    public void sayHelloServerStream(String request, StreamObserver<String> response) {
        response.onNext("接收到了:" + request+"1");
        response.onNext("接收到了:" + request+"2");
        response.onNext("接收到了:" + request);
        response.onCompleted();
    }
}
