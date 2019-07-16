package com.zh.learn.design_patterns.single_thread_execution;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class Tableware {

    //餐具名称
    private final String toolName;

    public Tableware(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "Tableware: " + toolName;
    }
}
