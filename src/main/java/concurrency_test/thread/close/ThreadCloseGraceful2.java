package concurrency_test.thread.close;

public class ThreadCloseGraceful2 {

    private static class WorkThread extends Thread {

        @Override
        public void run() {

            while (true) {
                if (Thread.interrupted()) {
                    break;
                }

//                if (this.isInterrupted()) {
//                    break;
//                }

                //todo
                System.out.println("doing.");

            }
        }
    }

    public static void main(String[] args) {
        WorkThread workThread = new WorkThread();
        workThread.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        workThread.interrupt();
    }

}
