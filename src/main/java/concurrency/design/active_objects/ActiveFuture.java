package concurrency.design.active_objects;

import concurrency.design.future.FutureTask;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    public void finish(T result) {
        super.finish(result);
    }
}
