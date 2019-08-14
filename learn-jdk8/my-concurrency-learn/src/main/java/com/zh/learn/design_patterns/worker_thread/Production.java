package com.zh.learn.design_patterns.worker_thread;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-13
 */
public class Production extends InstructionBook {

    private final int productId;

    public Production(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public void firstProcess() {
        System.out.println("execute the " + productId + " first process");
    }

    @Override
    public void secondProcess() {
        System.out.println("execute the " + productId + " second process");
    }
}
