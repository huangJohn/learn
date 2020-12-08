package com.zh.learn.mybatis.test.service;

import com.zh.learn.mybatis.test.model.User2;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/12/1
 */
public interface User2Service {

    void addRequired(User2 user2);
    boolean addRequired1(User2 user2);
    void addRequiredNew(User2 user2);

    void addRequiredException(User2 user2);
    boolean addRequiredException1(User2 user2);
    void addRequiredNewException(User2 user2);

    void addNested(User2 user2);
    void addNestedException(User2 user2);
}
