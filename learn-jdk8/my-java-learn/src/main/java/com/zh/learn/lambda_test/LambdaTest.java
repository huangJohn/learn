package com.zh.learn.lambda_test;

import java.util.Optional;
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

        Stream<String> stream2 = Stream.of("abc", "def");
        Optional<String> first = stream2.findFirst();
        first.ifPresent(System.out::println);

        Stream<String> stream3 = Stream.of("abc", "def", "xyz");
        stream3.filter(s -> s.startsWith("de"))
                .forEach(System.out::println);

    }

}
