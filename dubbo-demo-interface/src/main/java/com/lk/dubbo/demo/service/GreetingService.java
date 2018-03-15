package com.lk.dubbo.demo.service;

/**
 * 提供接口供服务提供方实现以及服务调用方调用
 * @author likun
 * @version V1.0
 * @Title: com.lk.dubbo.demo.service
 * @date 2018/3/15 15:37
 */
public interface GreetingService {
    String hello(String name);
}
