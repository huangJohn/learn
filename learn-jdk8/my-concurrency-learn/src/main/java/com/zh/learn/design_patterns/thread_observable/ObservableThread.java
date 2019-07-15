package com.zh.learn.design_patterns.thread_observable;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-15
 */
public class ObservableThread<T> extends Thread implements Observable {

    private final TaskLifeCycle<T> taskLifeCycle;

    private final Task<T> task;

    private Cycle cycle;

    //指定Task的实现，默认下使用EmptyTaskLifeCycle
    public ObservableThread(Task<T> task) {
        this(new TaskLifeCycle.EmptyTaskLifeCycle<T>(), task);
    }

    public ObservableThread(TaskLifeCycle<T> taskLifeCycle, Task<T> task) {

        super();
        if (task == null) {
            throw new IllegalArgumentException("this task is required.");
        }
        this.taskLifeCycle = taskLifeCycle;
        this.task = task;
    }

    /**
     * Description:
     * final定义，指明子类不能再复写run方法
     */
    @Override
    public final void run() {

        //执行线程逻辑单元开始前，触发相应事件
        this.update(Cycle.STARTED, null, null);
        try {
            //running，触发
            this.update(Cycle.RUNNING, null, null);
            T result = this.task.call();
            //finish，触发
            this.update(Cycle.DONE, result, null);
        } catch (Exception e) {
            //异常，触发
            this.update(Cycle.ERROR, null, e);
        }
    }

    private void update(Cycle cycle, T result, Exception ex) {
        this.cycle = cycle;
        if (taskLifeCycle == null) {
            return;
        }
        try {
            switch (cycle) {
                case STARTED:
                    this.taskLifeCycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.taskLifeCycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.taskLifeCycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.taskLifeCycle.onError(currentThread(), ex);
                    break;
            }
        } catch (Exception e) {
            if (cycle == Cycle.ERROR) {
                throw e;
            }
        }
    }

    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
