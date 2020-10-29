package com.zh.learn.aop.simple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-18
 *
 * Types of AOP Advices
 * There are five types of advice in spring AOP.
 *
 * Before advice: Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception).
 * 前置advice，方法调用前如果抛出ex，则阻断，否则执行完执行目标方法
 *
 * After returning advice: Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception.
 * 执行目标方法后，执行后置advice，在无ex下
 *
 * After throwing advice: Advice to be executed if a method exits by throwing an exception.
 * 执行目标方法，遇到ex后，执行的后置异常advice
 *
 * After advice: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return).
 * 目标方法执行后，都执行的后置advice，不管是否有异常ex或者无ex
 *
 * Around advice: Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception.
 * around 类型advice，可以在before or after方法调用附近增强，也可以强制执行自己的逻辑，忽略目标方法结果（正常返回or异常）
 */

@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("before test");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("after Test");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
