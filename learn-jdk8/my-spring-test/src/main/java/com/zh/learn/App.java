package com.zh.learn;

import com.zh.learn.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-27
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        System.out.println("context 启动成功");


        MessageService messageService = context.getBean(MessageService.class);

        System.out.println(messageService.getMessage());
    }

}
