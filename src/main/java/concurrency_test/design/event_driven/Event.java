package concurrency_test.design.event_driven;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }

}
