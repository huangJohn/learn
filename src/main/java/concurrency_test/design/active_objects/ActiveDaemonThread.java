package concurrency_test.design.active_objects;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class ActiveDaemonThread extends Thread{

    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue activeMessageQueue) {

        this.queue = activeMessageQueue;
        setDaemon(true);
    }

    @Override
    public void run() {
        for (; ; ) {
            /**
             * 从MethodMessage队列中取一个MethodMessage，然后执行execute方法
             */
            ActiveMessage activeMessage = queue.take();
            activeMessage.execute();
        }
    }



}
