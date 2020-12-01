package com.zh.learn.mybatis.test.service;

import com.zh.learn.mybatis.test.model.User1;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/12/1
 */
public interface User1Service {

    void addRequired(User1 user1);

    void addRequiredNew(User1 user1);

    void addNested(User1 user1);

}
