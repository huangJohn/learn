package concurrency_test.design.future;



/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface FutureService<IN, OUT> {

    //提交不需要返回值的任务，Future.get()方法返回的是null
    Future<?> submit(Runnable runnable);

    //提交需要返回值的任务，其中Task接口代替了Runnable接口
    Future<OUT> submit(Task<IN, OUT> task, IN input);

    //提交需要返回值的任务，其中Task接口代替了Runnable接口
    //增加回调接口，当任务执行完成后，Callback会得到执行
    Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback);

    //使用静态方法创建一个FutureService的实现
    static <IN,OUT> FutureService<IN,OUT> newService() {
        return new FutureServiceImpl<>();
    }
}
