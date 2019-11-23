package com.zh.learn.aop.introduction;

import static java.lang.Thread.sleep;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/11/23
 */
public class ForumService {

    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            sleep((long) (Math.random() * 1000 * 20));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            sleep((long) (Math.random() * 1000 * 20));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

