package com.zh.learn.jvm.oom.stack;

/**
 * Description:
 * 总内存减去heap最大，方法区最大，剩余就是栈容量
 * 每个线程分配的栈容量越大，建立的线程数自然少，建立时越容易把内存耗尽，OOM
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/20
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();

        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
