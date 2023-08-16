package com.platform.ahj.dubbocommon.service;


import com.platform.ahj.dubbocommon.entity.User;
import org.apache.dubbo.common.stream.StreamObserver;

/**
 * @Description: UserService接口
 * @Author: ZiYu
 * @Created on: 2023/08/03 9:13
 * @Since:
 */
// 缺省可按服务接口区分验证场景，如：@NotNull(groups = ValidationService.class)
public interface UserService {

    @interface GetUser{} // 与方法同名接口，首字母大写，用于区分验证场景，如：@NotNull(groups = ValidationService.Save.class)，可选
    /**
     * 方法getUser作用为：
     * 校验用户的名字不能为空
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author RainZiYu
     */
    String getUser(User user);
    String setUser(User user);
    @interface VerifyUserPhoneNumber{}
    /**
     * 方法verifyUserPhoneNumber作用为：
     * 校验用户手机号
     * @author RainZiYu
     * @param user
     * @throws
     * @return java.lang.String
     */
    String verifyUserPhoneNumber(User user);
    /**
     * 方法sayHelloStream作用为：
     * 双向流(BIDIRECTIONAL_STREAM)
     *
     * @param response
     * @return org.apache.dubbo.common.stream.StreamObserver<java.lang.String>
     * @throws
     * @author RainZiYu
     */
    StreamObserver<String> sayHelloStream(StreamObserver<String> response);

    /**
     * 方法sayHelloServerStream作用为：
     * 服务端流调用  流式接口 SERVER_STREAM(服务端流)
     *
     * @param request
     * @param response
     * @return void
     * @throws
     * @author RainZiYu
     */
    void sayHelloServerStream(String request, StreamObserver<String> response);
}
