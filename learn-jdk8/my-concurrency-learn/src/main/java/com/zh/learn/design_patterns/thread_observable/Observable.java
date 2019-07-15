package com.zh.learn.design_patterns.thread_observable;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public interface Observable {

    //定义任务的生命周期
    enum Cycle {
        STARTED,RUNNING,DONE,ERROR
    }

    //获取当前状态
    Cycle getCycle();

    //线程启动，屏蔽Thread的其他方法
    void start();

    //线程终端，屏蔽Thread的其他方法
    void interrupt();

}
