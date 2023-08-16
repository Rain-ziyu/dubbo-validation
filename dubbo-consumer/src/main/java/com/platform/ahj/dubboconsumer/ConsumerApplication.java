package com.platform.ahj.dubboconsumer;

import com.alibaba.fastjson2.JSON;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @Description: 消费者启动类
 * @Author: ZiYu
 * @Created on: 2023/08/15 14:15
 * @Since:
 */
@SpringBootApplication
@EnableDubbo
public class ConsumerApplication {
    public static List<String> getNetworkAddress() {
        List<String> result = new ArrayList<String>();
        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> addresses=ni.getInetAddresses();
                while(addresses.hasMoreElements()){
                    ip = addresses.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(':') == -1) {
                        result.add(ip.getHostAddress());
                    }
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
        List<String> networkAddress = getNetworkAddress();
        System.out.println(JSON.toJSONString(networkAddress));
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
