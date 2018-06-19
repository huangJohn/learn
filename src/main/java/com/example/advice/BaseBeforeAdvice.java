package com.example.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseBeforeAdvice implements MethodBeforeAdvice {

    /**
     * method : 切入的方法
     * args ：切入方法的参数
     * target ：目标对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("======进入before============");
        System.out.println("准备在" + target + "目标对象上用" + method + "方法操作，参数为 '" + args[0]);
        System.out.println("======退出before============");
    }
}
