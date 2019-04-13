package com.zh.learn.dubbotest.activate_test.impl;

import com.alibaba.dubbo.common.extension.Activate;
import com.zh.learn.dubbotest.activate_test.ActivateExt1;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-28
 */
@Activate(order = 2, group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt1 {

    @Override
    public String echo(String msg) {
        return "2";
    }
}
