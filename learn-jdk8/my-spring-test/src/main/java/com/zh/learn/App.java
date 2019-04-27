package com.zh.learn;

import com.zh.learn.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        Logger logger = LoggerFactory.getLogger(App.class);

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        logger.info("context 启动成功");


        MessageService messageService = context.getBean(MessageService.class);

        logger.info(messageService.getMessage());
    }

}
