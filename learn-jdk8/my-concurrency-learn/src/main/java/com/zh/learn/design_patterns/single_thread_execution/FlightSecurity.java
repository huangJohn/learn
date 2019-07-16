package com.zh.learn.design_patterns.single_thread_execution;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class FlightSecurity {

    private int count = 0;

    //登记牌
    private String boardingPass = "null";

    //身份证
    private String idCard = "null";

    /**
     * Description:
     * 不加锁，pass方法线程不安全，FlightSecurity共享变量boardingPass和idCard、count赋值操作可能交叉，不保证原子性
     * 增加synchronized关键字，排他性
     */
    public synchronized void pass(String boardingPass, String idCard) {

        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check();
    }

    private void check() {

        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            //不串行，toString方法前出现共享变量不安全问题，调toString方法时一个线程被唤醒而输出一样
            throw new RuntimeException("登机牌和身份证不匹配 " + toString());
        }
    }

    @Override
    public String toString() {
        return "the " + count + " passenger, boardingPass=[" + boardingPass + "] idCard[=" + idCard + "]";
    }
}
