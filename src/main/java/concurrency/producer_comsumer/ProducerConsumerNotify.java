package concurrency.producer_comsumer;

import java.util.stream.Stream;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class ProducerConsumerNotify {

    private static final Object LOCK = new Object();

    private volatile boolean produced;

    private volatile int index = 0;

    public void produce() {
        synchronized (LOCK) {
            while (produced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            index++;
            System.out.println(Thread.currentThread().getName()+" P-> " + index);
            LOCK.notifyAll();
            produced = true;
        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!produced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" C-> " + index);
            LOCK.notifyAll();
            produced = false;
        }
    }

    public static void main(String[] args) {

        ProducerConsumerNotify producerConsumerNotify = new ProducerConsumerNotify();

        Stream.of("p1","p2","p3").forEach(p->new Thread(p){
            @Override
            public void run() {
                while (true) {
                    producerConsumerNotify.produce();
                }
            }
        }.start());

        Stream.of("c1","c2","c3","c4","c5").forEach(p->new Thread(p){
            @Override
            public void run() {
                while (true) {
                    producerConsumerNotify.consume();
                }
            }
        }.start());
    }
}
