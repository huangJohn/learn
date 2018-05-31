package concurrency.thread.close;

public class ThreadCloseGraceful {


    public static void main(String[] args) {

        WorkThread workThread = new WorkThread();
        workThread.start();
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        workThread.shutDown();

    }


    private static class WorkThread extends Thread {

        private volatile boolean flag;

        public WorkThread() {
            this.flag = true;
        }

        @Override
        public void run() {
            while (flag) {
                //todo
                System.out.println("running...");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("over.");
            }
        }

        public void shutDown() {
            this.flag = false;
        }
    }
}
