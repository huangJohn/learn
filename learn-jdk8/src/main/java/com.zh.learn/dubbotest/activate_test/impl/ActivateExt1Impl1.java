package com.zh.learn.dubbotest.activate_test.impl;

import com.alibaba.dubbo.common.extension.Activate;
import com.zh.learn.dubbotest.activate_test.ActivateExt1;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-28
 */

@Activate(group = {"default_group"})
public class ActivateExt1Impl1 implements ActivateExt1 {

    @Override
    public String echo(String msg) {
        return "default_group";

    }
}
