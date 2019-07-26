package com.zh.learn.design_patterns.balking;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class BalkingClient {

    public static void main(String[] args) {

        BalkingData balkingData = new BalkingData("/Users/kevin/IdeaProjects/learn/learn-jdk8/my-concurrency-learn/src/main/java/com/zh/learn/design_patterns/balking/record.txt", "====begin===");

        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }

}
