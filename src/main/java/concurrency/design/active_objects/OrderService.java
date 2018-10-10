package concurrency.design.active_objects;

import concurrency.design.future.Future;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public interface OrderService {

    /**
     * 根据订单编号查询订单明细，有入参也有返回值，但是返回类型必须是Future
     */
    Future<String> findOrderDetails(long orderId);

    /**
     * 提交订单，没有返回值
     */
    void order(String account, long orderId);
}
