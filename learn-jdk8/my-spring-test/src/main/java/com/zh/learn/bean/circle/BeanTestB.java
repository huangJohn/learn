package com.zh.learn.bean.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/17
 */
@Component
public class BeanTestB {

    @Autowired
    private BeanTestA beanTestA;

    @Transactional
    public String testB() {
        return "testB";
    }
}
