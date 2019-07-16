package com.zh.learn.design_patterns.read_write_lock;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class SharedData {

    private final char[] buffer;

    private final ReadWriteLock readWriteLock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
        System.out.println("init data:");
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", buffer[i]);
        }
        System.out.println("");
    }

    public char[] read() throws InterruptedException {
        try {
            readWriteLock.readLock();
            return doRead();
        } finally {
            readWriteLock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        try {
            readWriteLock.writeLock();
            doWrite(c);
        } finally {
            readWriteLock.writeUnLock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuf[i] = buffer[i];
        }
        slowly(500);
        return newBuf;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
