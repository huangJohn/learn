package com.example.factory;

import com.example.entity.Customer;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class CustomerFactory {
    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setName("Ingo");
        customer.setAge(26);
        customer.setSex("male");
        return customer;
    }
}
