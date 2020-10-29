package com.zh.learn.aop.aop.tutorial.example;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/9/15
 */
public class EmployeeManager {

    public EmployeeDTO getEmployeeById(Integer employeeId) {
        System.out.println("Method getEmployeeById() called");
        return new EmployeeDTO(20, "zh");
    }

}
