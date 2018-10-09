package concurrency.design.worker_thread;

/**
 * @author zhuanghuang
 * @date 2018/10/9
 */

public abstract class InstructionBook {

    public final void create() {

        firstProcess();
        secondProcess();
    }

    protected abstract void firstProcess();
    protected abstract void secondProcess();

}
