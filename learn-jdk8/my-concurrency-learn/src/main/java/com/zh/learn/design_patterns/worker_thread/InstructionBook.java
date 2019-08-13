package com.zh.learn.design_patterns.worker_thread;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public abstract class InstructionBook {

    public final void create() {
        this.firstProcess();
        this.secondProcess();
    }

    public abstract void firstProcess();
    public abstract void secondProcess();

}
