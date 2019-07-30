package com.zh.learn.design_patterns.balking.document;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-30
 */
public class DocumentBalkingClient {
    public static void main(String[] args) {

        new DocumentEditThread("/Users/kevin/IdeaProjects/learn/learn-jdk8/my-concurrency-learn/src/main/java/com/zh/learn/design_patterns/balking/document/", "document.txt").start();
    }

}
