package com.zh.learn.dubbo_spi_test.spi_activate.impl;

import com.alibaba.dubbo.common.extension.Activate;
import com.zh.learn.dubbo_spi_test.spi_activate.ActivateExtension;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */
@Activate(group = {"default_group"})
public class DefaultGroupActivateExtensionImpl implements ActivateExtension {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
