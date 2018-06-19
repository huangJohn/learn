package com.example.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseAroundAdvice implements MethodInterceptor {

    /**
     * methodInvocation ：连接点
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("==========进入around==========");
        // 调用方法的参数
        Object[] args = methodInvocation.getArguments();
        // 调用的方法
        Method method = methodInvocation.getMethod();
        // 获取目标对象
        Object target = methodInvocation.getThis();
        // 执行完方法，调用proceed()方法，就会触发切入点方法执行
        Object returnValue = methodInvocation.proceed();
        System.out.println("参数：" + args[0]);
        System.out.println("方法：" + method);
        System.out.println("目标：" + target);
        System.out.println("返回值：" + returnValue);
        System.out.println("===========结束around===========");
        return returnValue;
    }
}
