package com.lk.dubbo.demo.service.impl;

import com.lk.dubbo.demo.service.GreetingService;

import java.util.Date;

/**
 * 服务提供方实现接口供调用方请求通过Zookeeper
 * @author likun
 * @version V1.0
 * @Title: com.lk.dubbo.demo.service.impl
 * @date 2018/3/15 16:03
 */

public class GreetingServiceImpl implements GreetingService {

    @Override
    public String hello(String name) {
        System.out.println("Hello Service is calling : " + new Date());
        String greetMessage = "Hello, " + name;
        return greetMessage;
    }
}
