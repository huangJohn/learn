package concurrency_test.design.active_objects;

import concurrency_test.design.future.Future;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class Client {
    public static void main(String[] args) throws InterruptedException {
//        OrderService orderService = OrderServiceFactory.toActiveObject(new OrderServiceImpl());
//        orderService.order("hello", 4123);
//
//        //立即返回
//        System.out.println("return immediately");
//        currentThread().join();

        OrderService orderService = ActiveServiceFactory.active(new OrderServiceImpl());
        Future<String> future = orderService.findOrderDetails(23423);
        System.out.println("i will be returned immediately");
        System.out.println(future.get());
    }
}
