package com.zh.learn.aop.aop.tutorial.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/9/15
 */
@Aspect
public class EmployeeCRUDAspect {

    //point-cut expression
    @Before("execution(* EmployeeManager.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint) {
        System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
    }

}
