package concurrency.runnable;

public class TicketWindowRunnable implements Runnable{

    private static final int MAX = 1000;

    private static  int INDEX = 1;

    @Override
    public void run() {
        while (INDEX <= MAX) {
            System.out.println("柜台："+Thread.currentThread().getName()+" -> "+"正在叫号："+(INDEX++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
