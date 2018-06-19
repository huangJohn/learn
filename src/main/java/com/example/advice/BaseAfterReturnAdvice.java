package com.example.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseAfterReturnAdvice implements AfterReturningAdvice {

    /**
     * o ：切入点执行完方法的返回值，但不能修改
     * method ：切入点方法
     * args ：切入点方法的参数
     * target ：目标对象
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("========进入after()=======");
        System.out.println(target + "目标对象被" + method + "方法操作了，操作参数为" + args[0]);
        System.out.println("========退出after()========");
    }
}
