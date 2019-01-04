package concurrency_test.atom_exercise;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeTest {

    /**
     * cost time record:
     * <p>
     * StupidCounter Counter result: 8969664
     * Time cost: 163
     * <p>
     * SyncCounter Counter result: 10000000
     * Time cost: 637
     * <p>
     * LockCounter Counter result: 10000000
     * Time cost: 310
     * <p>
     * AtomicCounter Counter result: 10000000
     * Time cost: 295
     * <p>
     * CASCounter Counter result: 10000000
     * Time cost: 1717
     */

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {


//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);
//        Unsafe unsafe = getUnsafe();
//        System.out.println(unsafe);

        ExecutorService executorService1 = Executors.newFixedThreadPool(1000);

        CASCounter counter1 = new CASCounter();
        LockCounter counter2 = new LockCounter();
        AtomicCounter counter3 = new AtomicCounter();
        SyncCounter counter4 = new SyncCounter();
        StupidCounter counter5 = new StupidCounter();

        performance(executorService1, counter1);
    }

    public static void performance(ExecutorService executorService, Counter counter) throws NoSuchFieldException, InterruptedException {

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new CounterRunnable(counter, 10000));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();

        System.out.println(counter.getCounterName() + " Counter result: " + counter.getCounter());
        System.out.println("Time cost: " + (end - start));
    }

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    interface Counter {

        void increment();

        long getCounter();

        String getCounterName();
    }

    static class StupidCounter implements Counter {

        private long counter = 0;

        private static final String NAME = "StupidCounter";

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }

        @Override
        public String getCounterName() {
            return NAME;
        }
    }

    static class SyncCounter implements Counter {

        private long counter = 0;

        private static final String NAME = "SyncCounter";

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }

        @Override
        public String getCounterName() {
            return NAME;
        }
    }

    static class LockCounter implements Counter {

        private final Lock lock = new ReentrantLock();

        private long counter = 0;

        private static final String NAME = "LockCounter";

        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }

        @Override
        public String getCounterName() {
            return NAME;
        }
    }

    static class AtomicCounter implements Counter {

        private AtomicLong counter = new AtomicLong();

        private static final String NAME = "AtomicCounter";

        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }

        @Override
        public String getCounterName() {
            return NAME;
        }
    }

    static class CASCounter implements Counter {

        private volatile long counter = 0;

        private Unsafe unsafe;

        private long offset;

        private static final String NAME = "CASCounter";

        CASCounter() throws NoSuchFieldException {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }


        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }

        @Override
        public String getCounterName() {
            return NAME;
        }
    }

    static class CounterRunnable implements Runnable {

        private final Counter counter;
        private final int num;

        CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

}
