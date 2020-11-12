package com.zh.learn.aop.aop.tutorial.example.jdkproxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/10/31
 */

@Aspect
@Component
public class ITestServiceApspect {

    @Before("execution(* ITestService.test(..))")
    public void logBeforeV1(JoinPoint joinPoint) {
        System.out.println("ITestServiceApspect.logBeforeV1() : " + joinPoint.getSignature().getName());
    }

}
