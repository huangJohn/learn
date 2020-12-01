package com.zh.learn.mybatis.test.service;

import com.zh.learn.mybatis.test.dao.User1Mapper;
import com.zh.learn.mybatis.test.model.User1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/12/1
 */
@Service
public class User1ServiceImpl implements User1Service{

    @Resource
    private User1Mapper user1Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addRequired(User1 user1) {
        user1Mapper.insert(user1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiredNew(User1 user1) {
        user1Mapper.insert(user1);
    }


}
