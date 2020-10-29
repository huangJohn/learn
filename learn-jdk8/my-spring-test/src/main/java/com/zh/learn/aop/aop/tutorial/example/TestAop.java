package com.zh.learn.aop.aop.tutorial.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/9/15
 */
public class TestAop {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        EmployeeManager manager = context.getBean(EmployeeManager.class);
        manager.getEmployeeById(1);
    }

}
