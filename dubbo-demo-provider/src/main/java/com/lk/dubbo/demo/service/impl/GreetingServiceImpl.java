package com.lk.dubbo.demo.service.impl;

import com.lk.dubbo.demo.service.GreetingService;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.util.Date;

/**
 * 服务提供方实现接口供调用方请求通过Zookeeper
 * @author likun
 * @version V1.0
 * @Title: com.lk.dubbo.demo.service.impl
 * @date 2018/3/15 16:03
 */

public class GreetingServiceImpl implements GreetingService {

    private static final Logger LOGGER = Logger.getLogger(GreetingServiceImpl.class);

    @Override
    public String hello(String name) {
        LOGGER.info("=================consumer请求======================");
        System.out.println("Hello Service is calling : " + new Date());
        String greetMessage = "Hello, " + name;
        return greetMessage;
    }
}
