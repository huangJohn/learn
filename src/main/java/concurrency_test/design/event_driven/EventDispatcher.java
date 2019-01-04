package concurrency_test.design.event_driven;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 最基本的实现，单线程，不考虑线程安全
 */
public class EventDispatcher implements DynamicRouter<Message> {

    //map保存Channel和Message之间关系
    private final Map<Class<? extends Message>, Channel> routerTable;

    public EventDispatcher() {

        //初始化table
        this.routerTable = new HashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {

        this.routerTable.put(messageType, channel);
    }

    @Override
    public void dispatch(Message message) {

        if (routerTable.containsKey(message.getType())) {
            //直接获取Channel处理Message
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("can't match the channel for message=[" + message.getType() + "] type");
        }
    }
}
