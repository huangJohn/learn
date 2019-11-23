package com.zh.learn.aop.introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/11/23
 */
public class IntroductionTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        ForumService forumService = (ForumService) ctx.getBean("forumService");
        forumService.removeForum(10);
        forumService.removeTopic(1022);

        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(10);
        forumService.removeTopic(1022);

    }

}
