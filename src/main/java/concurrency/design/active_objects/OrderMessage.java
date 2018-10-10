package concurrency.design.active_objects;

import java.util.Map;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class OrderMessage extends MethodMessage {


    protected OrderMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {

        //获取参数
        String account = (String) params.get("account");
        long orderId = (long) params.get("orderId");
        //真正执行
        orderService.order(account, orderId);
    }
}
