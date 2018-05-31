package com.example.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseBeforeAdvice implements MethodBeforeAdvice {

    /**
     * method : 切入的方法 <br>
     * args ：切入方法的参数 <br>
     * target ：目标对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("======进入before()============");
        System.out.print("准备在" + target + "对象上用");
        System.out.print(method + "方法进行对 '");
        System.out.println(args[0] + "'进行删除！");
        System.out.println("======退出before()============");
    }
}
