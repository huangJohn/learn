package com.zh.learn.bean.circle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/17
 */
public class Client {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        BeanTestA beanTestA = applicationContext.getBean(BeanTestA.class);
        BeanTestB beanTestB = applicationContext.getBean(BeanTestB.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String b : beanDefinitionNames) {
            System.out.println(b);
        }

    }

}
