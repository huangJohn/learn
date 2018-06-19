package com.example.service;

import com.example.entity.Customer;

/**
 * @author zhuanghuang
 * @since 2018/5/28
 */
public interface IBaseBusiness {
    /**
     * 用作代理的切入点方法
     *
     * @param obj
     * @return
     */

    public void delete(Customer obj);

    public String add(Customer obj);

    public void modify(Customer obj);
}
