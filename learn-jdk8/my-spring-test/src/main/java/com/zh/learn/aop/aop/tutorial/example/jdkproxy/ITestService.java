package com.zh.learn.aop.aop.tutorial.example.jdkproxy;

import org.springframework.stereotype.Component;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/31
 */
@Component
public interface ITestService {

    String test(String s);
}
