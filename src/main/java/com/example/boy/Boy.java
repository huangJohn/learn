package com.example.boy;

import com.example.service.GetMarried;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class Boy {

    public static void main(String[] args) {
        //首先读取配置文件，配置文件中的bean将会保存到ApplicationContext的实例中
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
        //从ApplicationContext的实例中按照id值获取对应类的实例对象，并且需要进行强制类型
        GetMarried gm = (GetMarried) ac.getBean("getMarried");
        //使用对象的内部方法，就像我们使用new创建的对象一样
        gm.getMarried();
    }
}
