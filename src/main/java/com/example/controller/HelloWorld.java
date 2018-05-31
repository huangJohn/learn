package com.example.controller;

import com.example.entity.Customer;
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

//        //首先读取配置文件，配置文件中的bean将会保存到ApplicationContext的实例中
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
//        //从ApplicationContext的实例中按照id值获取对应类的实例对象，并且需要进行强制类型
//        TestWork tw = (TestWork) ac.getBean("helloworld");
//        //使用对象的内部方法，就像我们使用new创建的对象一样
//        tw.sayHello();


//        //首先读取配置文件，配置文件中的bean将会保存到ApplicationContext的实例中
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
//        //从ApplicationContext的实例中按照id值获取对应类的实例对象，并且需要进行强制类型转化
//        Customer customer2 = (Customer) ac.getBean("customer2");
//        Customer customer1 = (Customer) ac.getBean("customer1");
//        Customer customer3 = (Customer) ac.getBean("customer3");
//        Customer customer4 = (Customer) ac.getBean("customer4");
//        Customer customer5 = (Customer) ac.getBean("customer5");
//        Customer customer6 = (Customer) ac.getBean("customer6");
//        //使用对象的内部方法，就像我们使用new创建的对象一样
//        System.out.println(customer2);
//        System.out.println(customer1);
//        System.out.println(customer3);
//        System.out.println(customer4);
//        System.out.println(customer5);
//        System.out.println(customer6);


        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        IBaseBusiness business = (IBaseBusiness) context.getBean("businessProxy2");
        Customer customer2 = (Customer) context.getBean("customer2");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business.delete(customer2);

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business.add(customer2.getName());

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        business.modify(customer2);

        System.out.println("++++++++++++++++++++++++++++++++++++++");

    }
}
