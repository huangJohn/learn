package com.zh.learn.jvm.oom.stack;

/**
 * Description:
 * 单线程下，无论是栈帧太大还是虚拟机栈容量太小，都产生StackOverflowError异常
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/20
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length = " + javaVMStackSOF.stackLength);
            throw e;
        }
    }

}
