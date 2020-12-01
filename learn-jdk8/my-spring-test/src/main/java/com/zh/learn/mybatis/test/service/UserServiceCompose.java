package com.zh.learn.mybatis.test.service;

import com.zh.learn.mybatis.test.model.User1;
import com.zh.learn.mybatis.test.model.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/12/1
 */
@Service
public class UserServiceCompose {

    @Autowired
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;

    @Transactional(propagation = Propagation.REQUIRED)
    public void test() {

        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequired(user2);//fail

        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test2() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredException(user2);//fail

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test3() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        try {
            user2Service.addRequiredException(user2);//fail
        } catch (Exception e) {
            System.out.println("user2Service.addRequiredException.");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test4() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredNew(user2);//succ


        User2 user3 = new User2();
        user3.setName("lisi");
        user2Service.addRequiredNew(user3);//succ

        throw new RuntimeException();

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test5() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredNew(user2);//succ


        User2 user3 = new User2();
        user3.setName("lisi");
        user2Service.addRequiredNewException(user3);//fail


    }
}
