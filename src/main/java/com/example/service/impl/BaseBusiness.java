package com.example.service.impl;

import com.example.entity.Customer;
import com.example.service.IBaseBusiness;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public class BaseBusiness implements IBaseBusiness {

    /**
     * 切入点
     */
    @Override
    public void delete(Customer obj) {
        System.out.println("||///////////////////||");
        System.out.println("删除用户:"+obj.getName());
        System.out.println("||///////////////////||");
    }

    @Override
    public String add(Customer obj) {
        System.out.println("||///////////////////||");
        System.out.println("add用户:"+obj.getName());
        System.out.println("||///////////////////||");
        return obj.getName();
    }

    @Override
    public void modify(Customer obj) {
        System.out.println("|///////////////////||");
        System.out.println("modify用户:"+obj.getName());
        System.out.println("|///////////////////||");
    }
}
