package com.zh.learn.design_patterns.even_bus;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-15
 */
public interface Bus {

    /**
     * Description:
     * 将某个对象注册到bus上，从此之后这个对象成为订阅者
     */
    void register(Object subscriber);

    /**
     * Description:
     * 取消注册，不再接受bus消息
     */
    void unRegister(Object subscriber);

    /**
     * Description:
     * 提交某个事件到bus，默认topic
     */
    void post(Object event);

    /**
     * Description:
     * 提交莫哥事件到bus，指定topic
     */
    void post(Object event, String topic);

    /**
     * Description:
     * 关闭
     */
    void close();

    /**
     * Description:
     * 获取bus名字
     */
    String getBusName();
}
