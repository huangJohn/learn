package com.zh.learn.design_patterns.even_bus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {

    String topic() default "default-topic";
}
