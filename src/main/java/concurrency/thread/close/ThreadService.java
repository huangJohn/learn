package concurrency.thread.close;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class ThreadService {

    private Thread executeThread;

    private boolean finished;

    public static void main(String[] args) {

        ThreadService service = new ThreadService();
        long s = System.currentTimeMillis();
        service.execute(()->{
            while (true) {

            }

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //---
        });
        service.shutDown(5000);
        long en = System.currentTimeMillis();
        System.out.println(en-s);
    }

    public void execute(Runnable task) {

        executeThread = new Thread() {
            @Override
            public void run() {

                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();

                try {
                    runner.join();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
                finished = true;
            }
        };

        executeThread.start();
    }

    public void shutDown(long ms) {
        long cur = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - cur > ms) {
                System.out.println("超时，需要结束它");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(100);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("执行线程被打断");
                break;
            }
        }

        finished = false;
    }
}
