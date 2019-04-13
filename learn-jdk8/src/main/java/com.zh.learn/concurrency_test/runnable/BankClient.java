package com.zh.learn.concurrency_test.runnable;

public class BankClient {

    public static void main(String[] args) {
        TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread t1 = new Thread(ticketWindowRunnable, "No.1");
        Thread t2 = new Thread(ticketWindowRunnable, "No.2");
        Thread t3 = new Thread(ticketWindowRunnable, "No.3");
        t1.start();
        t2.start();
        t3.start();
    }

}
