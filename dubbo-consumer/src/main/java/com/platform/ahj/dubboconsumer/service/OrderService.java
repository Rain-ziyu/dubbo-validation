package com.platform.ahj.dubboconsumer.service;


import com.platform.ahj.dubbocommon.entity.User;
import com.platform.ahj.dubbocommon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @Description: 订单服务
 * @Author: ZiYu
 * @Created on: 2023/08/03 9:18
 * @Since:
 */
@Slf4j
@Service
public class OrderService {
    // 进行调用方参数校验   提供方参数校验其参数异常无法正常序列化至调用方
    @DubboReference(version = "2.0")
    private UserService userService;

    public String getOrder() {

        // 测试单向流
        userService.sayHelloServerStream("hhh", new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                log.info("接收到消息:" + data);
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("调用出错");
            }

            @Override
            public void onCompleted() {
                log.info("调用完成");
            }
        });
        // 双向流调用
        StreamObserver<String> stringStreamObserver = userService.sayHelloStream(new StreamObserver<String>() {
            @Override
            public void onNext(String data) {
                log.info("双向流接收到消息:" + data);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                log.info("双端流调用完成");
            }
        });
        // 向服务端发送消息
        stringStreamObserver.onNext("1");
        stringStreamObserver.onNext("2");
        stringStreamObserver.onNext("3");
        stringStreamObserver.onCompleted();
        // 测试参数校验
        String s = null;
        try {
            s = userService.verifyUserPhoneNumber(new User());
        } catch (Exception e) {
            // 不会出现异常而是s
            throw new RuntimeException(e);
        }
        log.info("验证参数的verifyUserPhoneNumber方法返回的是：{}",s);
        String s1 = userService.getUser(new User());
        log.info("验证参数的getUser方法返回的是：{}",s1);
        String s2 = userService.setUser(new User());
        log.info("验证参数的setUser方法返回的是：{}",s2);
        return "wwl";
    }
}
