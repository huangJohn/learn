package concurrency.design.future;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class FutureTask<T> implements Future<T> {

    //计算结果
    private T result;

    //任务是否完成
    private boolean isDone = false;

    //锁对象
    private static final Object LOCK = new Object();

    @Override
    public T get() throws InterruptedException {

        synchronized (LOCK) {

            //任务没有完成时，调用get方法会被挂起而进去阻塞状态
            while (!done()) {
                LOCK.wait();
            }
            return result;
        }
    }

    //finish方法主要用于为FutureTask设置计算结果
    protected void finish(T result) {
        synchronized (LOCK) {
            //balking设计模式
            if (done()) {
                return;
            }
            //计算完成，为result指定结果，将isDone设置为true，同时唤醒阻塞中的线程
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }
}
