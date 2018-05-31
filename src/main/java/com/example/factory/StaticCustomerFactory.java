package com.example.factory;

import com.example.entity.Customer;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class StaticCustomerFactory {
    public static Customer createCustomer(){
        Customer customer = new Customer("Rose","male",27);
//        customer.setName("Rose");
//        customer.setAge(27);
//        customer.setSex("male");
        return customer;
    }
}
