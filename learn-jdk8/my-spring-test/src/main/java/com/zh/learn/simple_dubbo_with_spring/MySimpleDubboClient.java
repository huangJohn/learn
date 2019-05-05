package com.zh.learn.simple_dubbo_with_spring;

import com.zh.learn.dynamic_proxy.jdk_impl.MenuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:模拟dubbo consumer
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MySimpleDubboClient {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:my-dubbo-consumer.xml");
        MenuService menuService = context.getBean(MenuService.class);

        menuService.sayHello();
    }

}
