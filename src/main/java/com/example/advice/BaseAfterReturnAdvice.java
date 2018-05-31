package com.example.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseAfterReturnAdvice implements AfterReturningAdvice {

    /**
     * o ：切入点执行完方法的返回值，但不能修改 <br>
     * method ：切入点方法 <br>
     * args ：切入点方法的参数数组 <br>
     * target ：目标对象
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("======进入after()======");
        System.out.println(args[0] + "在");
        System.out.println(target + "对象上被");
        System.out.println(method + "方法删除了");
        System.out.println("=======退出after()=======");
    }
}
