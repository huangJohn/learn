package com.zh.learn.dubbo_spi_test.spi_adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */

@SPI("dubbo")
public interface AdaptiveExtension {

    @Adaptive({"t1","t2"})
//    @Adaptive
    String echo(String msg, URL url);
}
