package com.zh.learn.dubbo_spi_test.spi_adaptive.impl;

import com.alibaba.dubbo.common.URL;
import com.zh.learn.dubbo_spi_test.spi_adaptive.AdaptiveExtension;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */
public class DubboAdaptiveExtensionImpl implements AdaptiveExtension {

    @Override
    public String echo(String msg, URL url) {

        return "dubbo";
    }
}
