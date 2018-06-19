package com.example.controller;

import com.example.entity.Customer;
import com.example.service.GetMarried;
import com.example.service.IBaseBusiness;
import com.example.service.TestWork;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class HelloWorld {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestWork tw = (TestWork) ac.getBean("helloworld");
        tw.sayHello();
        System.out.println("-------------------------");

        GetMarried getMarried = (GetMarried) ac.getBean("getMarried");
        getMarried.getMarried();
        System.out.println("--------------------------");

        ApplicationContext ac1 = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Customer customer1 = (Customer) ac1.getBean("customer1");
        Customer customer2 = (Customer) ac1.getBean("customer2");
        Customer customer3 = (Customer) ac1.getBean("customer3");
        Customer customer4 = (Customer) ac1.getBean("customer4");
        Customer customer5 = (Customer) ac1.getBean("customer5");
        Customer customer6 = (Customer) ac1.getBean("customer6");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
        System.out.println(customer5);
        System.out.println(customer6);
        System.out.println("--------------------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IBaseBusiness business = (IBaseBusiness) context.getBean("businessProxy");
        Customer customer22 = (Customer) context.getBean("customer2");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business.delete(customer22);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business.add(customer22);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business.modify(customer22);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("--------------------------");

        IBaseBusiness business2 = (IBaseBusiness) context.getBean("businessProxy2");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business2.delete(customer22);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business2.add(customer22);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business2.modify(customer22);
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("--------------------------");

    }
}
