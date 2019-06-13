package com.zh.learn.dubbo_spi_test.spi_activate;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */

@SPI
public interface ActivateExtension {

    String echo(String msg);
}
