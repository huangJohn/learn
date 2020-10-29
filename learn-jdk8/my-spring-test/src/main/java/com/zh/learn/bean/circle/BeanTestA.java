package com.zh.learn.bean.circle;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/17
 */

@Component
public class BeanTestA {

    @Autowired
    private BeanTestB beanTestB;

    @Async
    public void testA() {
        System.out.println("test!");
    }


}
