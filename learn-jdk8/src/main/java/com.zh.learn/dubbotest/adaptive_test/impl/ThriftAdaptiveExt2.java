package com.zh.learn.dubbotest.adaptive_test.impl;

import com.alibaba.dubbo.common.URL;
import com.zh.learn.dubbotest.adaptive_test.AdaptiveExt2;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-27
 */
//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(URL url, String msg) {
        return "thrift";
    }
}
