package com.zh.learn.design_patterns.two_phase_termination.reference.strong;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */
public class Reference {

    //1M
    private final byte[] data = new byte[2 << 19];

    //只是标记
    @Override
    protected void finalize() throws Throwable {
        System.out.println("the refenrece will be GC.");
    }
}
