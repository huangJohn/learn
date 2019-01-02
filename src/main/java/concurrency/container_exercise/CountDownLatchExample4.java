package concurrency.container_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/1/2
 */
public class CountDownLatchExample4 {


    /**
     * 场景:
     * 数据同步下，一台机器上有多个tables需要采集到另外的机器上，每次消息传递使用event驱动，
     * 才源机器上采集是并发执行，不是对应到目的机器上table的关系，而到目的机器上假设需要核实2个值，分别是recordCount和对应row填充，
     * 采集过程中目的机器可能有多个，数据到达时并不是串行，一个一个更新，再确认对比总数，
     * 而是拆分每个table的任务为任务1，同步recordCount，任务2同步每row，则此时
     * 一个table既要核实count又是核实每row数据，则可以用latch down做，同时，一个table更新完后，
     * 这一event上的多个table也可以用latch down，都做完后则一个event更新处理完毕
     * 对此，用户可以方便知道一次批处理多个table中有多少是成功的
     *
     * @param
     * @return
     */

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        Event[] events = new Event[]{new Event(1), new Event(2)};
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Event event : events) {
            List<Table> tables = capture(event);
            TaskGroup taskGroup = new TaskGroup(tables.size(), event);

            for (Table table : tables) {
                TaskBatch taskBatch = new TaskBatch(2, taskGroup);
                TrustSourceColumns trustSourceColumns = new TrustSourceColumns(table, taskBatch);
                TrustSourceRecordCount trustSourceRecordCount = new TrustSourceRecordCount(table, taskBatch);

                service.submit(trustSourceColumns);
                service.submit(trustSourceRecordCount);
            }

        }

        service.shutdown();
    }

    private static class TrustSourceColumns implements Runnable {

        private final Table table;
        private final TaskBatch taskBatch;

        private TrustSourceColumns(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            table.targetColumnSchema = table.sourceColumnSchema;
            taskBatch.done(table);
        }
    }

    private static class TrustSourceRecordCount implements Runnable {

        private final Table table;
        private final TaskBatch taskBatch;

        private TrustSourceRecordCount(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {

            try {
                TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            table.targetRecordCount = table.sourceRecordCount;
            taskBatch.done(table);
        }
    }

    private static List<Table> capture(Event event) {
        List<Table> list = new ArrayList<Table>();
        for (int i = 1; i < 11; i++) {
            list.add(new Table("table-" + event.id + "-" + i, i * 1000));
        }
        return list;
    }

    private static class Event {
        private final int id;

        private Event(int id) {
            this.id = id;
        }
    }

    private static class Table {
        private String tableName;
        private long sourceRecordCount = 10L;
        private long targetRecordCount;
        private String sourceColumnSchema = "<table name='a'><column name='col1' type='varchar2'/></table>";
        private String targetColumnSchema = "";

        public Table(String tableName, long sourceRecordCount) {
            this.tableName = tableName;
            this.sourceRecordCount = sourceRecordCount;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    ", sourceRecordCount=" + sourceRecordCount +
                    ", targetRecordCount=" + targetRecordCount +
                    ", sourceColumnSchema='" + sourceColumnSchema + '\'' +
                    ", targetColumnSchema='" + targetColumnSchema + '\'' +
                    '}';
        }
    }

    interface Watcher {
        void done(Table table);
    }

    private static class TaskBatch implements Watcher {

        private CountDownLatch countDownLatch;
        private TaskGroup taskGroup;

        public TaskBatch(int size, TaskGroup taskGroup) {
            this.countDownLatch = new CountDownLatch(size);
            this.taskGroup = taskGroup;
        }

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("The table " + table.tableName + " finished work, [" + table + "]");
                taskGroup.done(table);
            }
        }
    }

    private static class TaskGroup implements Watcher {

        private CountDownLatch countDownLatch;
        private Event event;

        public TaskGroup(int size, Event event) {
            this.countDownLatch = new CountDownLatch(size);
            this.event = event;
        }

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("=====All of table done in event:" + event.id);
            }

        }
    }


}
