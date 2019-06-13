package com.zh.learn.dubbo_spi_test.spi_activate.impl;

import com.alibaba.dubbo.common.extension.Activate;
import com.zh.learn.dubbo_spi_test.spi_activate.ActivateExtension;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */
@Activate(order = 2, group = "order")
public class OrderGroup2ActivateExtensionImpl implements ActivateExtension {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
