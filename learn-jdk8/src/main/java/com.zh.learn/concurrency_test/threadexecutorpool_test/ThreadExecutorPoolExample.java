package com.zh.learn.concurrency_test.threadexecutorpool_test;

import java.util.concurrent.*;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-01
 */
public class ThreadExecutorPoolExample {

    public ThreadExecutorPoolExample() {
    }

    public ThreadPoolExecutor create(int corePoolSize,
                                     int maximumPoolSize,
                                     long keepAliveTime,
                                     TimeUnit unit,
                                     BlockingQueue<Runnable> workQueue,
                                     ThreadFactory threadFactory,
                                     RejectedExecutionHandler handler) {

        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

}
