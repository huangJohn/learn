package com.zh.learn.aop.aop.tutorial.example.jdkproxy;


import com.zh.learn.aop.aop.tutorial.example.EmployeeManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/9/15
 */
public class TestAop1 {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        ITestService bean = context.getBean(ITestService.class);

        System.out.println(bean);
        System.out.println(bean.test(2 + ""));

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String b : beanDefinitionNames) {
            System.out.println(b);
        }


    }

}
