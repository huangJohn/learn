package com.zh.learn.design_patterns.thread_observable;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public interface TaskLifeCycle<T> {

    //任务启动触发onStart方法
    void onStart(Thread thread);

    //任务正在运行触发onRunning方法
    void onRunning(Thread thread);

    //任务结束触发onFinish方法，其中result是任务执行结束后的结果
    void onFinish(Thread thread, T result);

    //任务执行出现异常触发onError方法，ex是异常
    void onError(Thread thread, Exception ex);

    //空实现，Adaptrt
    class EmptyTaskLifeCycle<T> implements TaskLifeCycle<T> {
        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception ex) {

        }
    }


}
