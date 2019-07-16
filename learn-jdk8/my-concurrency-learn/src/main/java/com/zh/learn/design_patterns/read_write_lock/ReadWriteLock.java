package com.zh.learn.design_patterns.read_write_lock;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class ReadWriteLock {

    private int readingReaders = 0;//正在读的线程数

    private int waitingReaders = 0;//等待读的线程数

    private int writingWriters = 0;//正在写的线程，最多1个

    private int waitingWriters = 0;//等待写的线程，>=0

    private boolean preferWriter;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock() throws InterruptedException {
        this.waitingReaders++;
        try {
            while (this.writingWriters > 0 || (this.preferWriter && this.waitingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            this.waitingReaders--;
        }
    }

    public synchronized void readUnLock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waitingWriters++;
        try {
            while (this.readingReaders > 0 || this.writingWriters > 0) {
                this.wait();
            }
            this.writingWriters++;
        } finally {
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnLock() {
        this.writingWriters--;
        this.notifyAll();
    }
}
