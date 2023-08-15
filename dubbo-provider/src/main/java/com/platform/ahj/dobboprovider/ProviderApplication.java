package com.platform.ahj.dobboprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
/**
 * @Description: ${description}
 * @Author: ZiYu
 * @Created on: 2023/08/15 14:21
 * @Since:
 */
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}