package com.platform.ahj.dubboconsumer.controller;


import com.platform.ahj.dubboconsumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ZiYu
 * @Created on: 2023/08/03 9:18
 * @Since:
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/a")
    public String getOrder(){
        return orderService.getOrder();
    }
}
