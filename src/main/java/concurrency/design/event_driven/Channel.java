package concurrency.design.event_driven;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public interface Channel<E extends Message> {

    /**
     * dispatch方法用于负责Message的调度
     */
    void dispatch(E message);
}
