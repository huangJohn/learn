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
        user1Service.addRequired(user1);//fail，加入事务

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequired(user2);//fail，加入事务

        throw new RuntimeException();//外部事务ex，影响内部加入的子事务提交db
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test2() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail，加入事务

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredException(user2);//fail，外部事务ex，来自加入事务2ex，内部加入事务均失败提交db

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test3() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//fail，加入型事务提交失败

        User2 user2 = new User2();
        user2.setName("lisi");
        try {
            user2Service.addRequiredException(user2);//fail，加入型事务ex，外部均fail。全部均失败提交
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
        user2Service.addRequiredNewException(user3);//内部自己fail
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test6() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredNew(user2);//succ

        User2 user3 = new User2();
        user3.setName("lisi");
        try {
            user2Service.addRequiredNewException(user3);//fail，内部ex不影响外部事务
        } catch (Exception e) {
            System.out.println("回滚user3");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test7() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addNested(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addNested(user2);//succ

        User2 user3 = new User2();
        user3.setName("lisi");
        try {
            user2Service.addNestedException(user3);//fail，内部独立ex，不影响外部，外部catch无感知
        } catch (Exception e) {
            System.out.println("回滚user3");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test8() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addNested(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addNested(user2);//fail

        User2 user3 = new User2();
        user3.setName("lisi");
        user2Service.addNestedException(user3);//fail，内部独立ex影响外部，外部感知
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void test9() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addNested(user1);//fail

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addNested(user2);//fail

        throw new RuntimeException();
    }
}
