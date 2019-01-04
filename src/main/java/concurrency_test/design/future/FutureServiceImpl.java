package concurrency_test.design.future;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {

    /**
     * FutureServiceImpl作用在于当提交任务是创建一个新的线程来受理该任务，进而达到任务异步执行的效果
     */

    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger nextCounter = new AtomicInteger();

    private String getNextName() {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {

        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            //任务执行完成后将null作为结果传给future
            future.finish(null);

        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {

        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            //任务执行完成之后将真实结果通过finish方法传递给future
            future.finish(result);
            //
        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            //任务执行完成之后将真实结果通过finish方法传递给future
            future.finish(result);
            //执行回调接口
            if (null != callback) {
                callback.call(result);
            }
        }, getNextName()).start();
        return future;
    }

}
