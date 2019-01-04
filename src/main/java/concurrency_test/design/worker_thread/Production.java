package concurrency_test.design.worker_thread;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public class Production extends InstructionBook {

    private final int productId;

    public Production(int productId) {
        this.productId = productId;
    }


    @Override
    protected void firstProcess() {
        System.out.println("execute the " + productId + " first process");
    }

    @Override
    protected void secondProcess() {
        System.out.println("execute the " + productId + " second process");
    }

    @Override
    public String toString() {
        return "Production-[" + productId + "]";
    }
}
