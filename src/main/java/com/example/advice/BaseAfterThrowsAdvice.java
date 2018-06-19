package com.example.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseAfterThrowsAdvice implements ThrowsAdvice {

    /**
     * 异常通知方法
     *
     * @param method    切入的方法
     * @param args      切入的方法的参数
     * @param target    目标对象
     * @param throwable 必填 : 异常子类，出现这个异常类的子类，则会进入这个通知。
     */
    public void afterThrowing(Method method, Object[] args, Object target, Throwable throwable) {
        System.out.println(method + "操作出错");
    }
}
