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
    public String add(String add) {
        System.out.println("||///////////////////||");
        System.out.println("add用户:"+add);
        System.out.println("||///////////////////||");
        return add;
    }

    @Override
    public void modify(Customer obj) {
        System.out.println("|///////////////////||");
        System.out.println("modify用户:"+obj.getName());
        System.out.println("|///////////////////||");
    }
}
