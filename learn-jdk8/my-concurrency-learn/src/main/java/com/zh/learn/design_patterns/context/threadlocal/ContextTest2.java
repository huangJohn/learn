package com.zh.learn.design_patterns.context.threadlocal;

import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class ContextTest2 {

    public static void main(String[] args) {

        IntStream.range(1,5).forEach(
                i->{
                    new Thread(new ExecutionTask2()).start();
                }
        );
    }

}
