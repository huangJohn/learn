package com.zh.learn.design_patterns.single_thread_execution;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class TablewarePair {

    /**
     * Description:解决死锁问题，把左右tool看成一个obj
     */

    private final Tableware leftTool;
    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool) {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool() {
        return leftTool;
    }

    public Tableware getRightTool() {
        return rightTool;
    }
}
