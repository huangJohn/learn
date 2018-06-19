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
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GetMarried gm = (GetMarried) ac.getBean("getMarried");
        gm.getMarried();
    }
}
