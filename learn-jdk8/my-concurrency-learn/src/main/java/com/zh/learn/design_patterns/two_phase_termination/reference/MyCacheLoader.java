package com.zh.learn.design_patterns.two_phase_termination.reference;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-10
 */

@FunctionalInterface
public interface MyCacheLoader<K, V> {

    V load(K k);

}
