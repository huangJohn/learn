package com.zh.learn.design_patterns.context;

import java.util.stream.IntStream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class ContextTest {

    public static void main(String[] args) {

        IntStream.range(1,5).forEach(
                i->{
                    new Thread(new ExecutionTask()).start();
                }
        );
    }

}
