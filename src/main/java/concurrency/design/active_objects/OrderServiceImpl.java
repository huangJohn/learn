package concurrency.design.active_objects;

import concurrency.design.future.Future;
import concurrency.design.future.FutureService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class OrderServiceImpl implements  OrderService {

    /**
     * 返回值是Future类型，因为方法的执行实在其他线程中进行，势必不会立即得到正确的执行结果，通过Future可以立即返回
     */
    @ActiveMethod
    @Override
    public Future<String> findOrderDetails(long orderId) {
        return FutureService.<Long, String>newService().submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("process the oriderId-" + orderId);
            return "the order details information";
        }, orderId, null);
    }

    @ActiveMethod
    @Override
    public void order(String account, long orderId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("process the order for account-" + account + " , orderId-" + orderId);
    }
}
