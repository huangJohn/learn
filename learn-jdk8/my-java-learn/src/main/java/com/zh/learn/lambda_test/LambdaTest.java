package com.zh.learn.lambda_test;

import java.util.stream.Stream;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-12
 */
public class LambdaTest {

    public static void main(String[] args) {


        Stream<String> stream = Stream.of("123", "1234");

        stream.forEach(s -> {
            if (s.length() > 3) {
                System.out.println(123);
            }
        });


    }

}
