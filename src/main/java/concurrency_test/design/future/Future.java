package concurrency_test.design.future;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface Future<T> {

    //返回计算后的结果，该方法会陷入阻塞状态
    T get() throws InterruptedException;

    //判断任务是否已经被执行完成
    boolean done();
}
