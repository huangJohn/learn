package concurrency_test.design.active_objects;

import java.util.Map;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public abstract class MethodMessage {

    /**
     * 收集每一个接口的方法参数，并且提供execute方法供ActiveDaemonThread使用
     * 该对象就是典型的Worker Thread模型中的Product
     * execute方法则是加工该Product的说明书
     */

    //用于收集方法参数，如果有返回值Future类型则一并收集
    protected final Map<String, Object> params;

    /**
     * 具体接口的实现，每一个方法都被拆分成不同的message
     * OrderService中定义了两个方法，因此实现两个MethodMessage
     */
    protected final OrderService orderService;

    protected MethodMessage(Map<String, Object> params, OrderService orderService) {
        this.params = params;
        this.orderService = orderService;
    }

    //抽象方法，扮演流水线模型的说明书
    public abstract void execute();
}
