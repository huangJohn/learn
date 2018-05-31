package concurrency.thread.interrupt;

import sun.awt.windows.WPrinterJob;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class ThreadInterrupt {

    private static final Object MONI = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    if (Thread.currentThread().isInterrupted()) {
//                        break;
//                    }
                    //....
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });

        t1.start();

        System.out.println(">>>>" + t1.isInterrupted());
        t1.interrupt();
        System.out.println(">>>>"+t1.isInterrupted());


        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (MONI) {
                    while (true) {

                        try {
                            MONI.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }
        };

        t2.start();

        System.out.println(">>>>2" + t2.isInterrupted());
        t2.interrupt();
        System.out.println(">>>>2"+t2.isInterrupted());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------");


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });

        t3.start();


        Thread cur = Thread.currentThread();
        Thread t4 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cur.interrupt();
            System.out.println("interrupt.");
        });

        t4.start();

        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            //close
        }
    }

}
