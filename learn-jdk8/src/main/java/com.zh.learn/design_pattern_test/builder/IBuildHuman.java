package com.zh.learn.design_pattern_test.builder;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface IBuildHuman {

    void buildHead();
    void buildBody();
    void buildHand();
    void buildFoot();

    Human createHuman();
}