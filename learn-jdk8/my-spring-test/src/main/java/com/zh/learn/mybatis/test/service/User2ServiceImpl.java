package com.zh.learn.mybatis.test.service;

import com.zh.learn.mybatis.test.dao.User2Mapper;
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
public class User2ServiceImpl implements User2Service{

    @Autowired
    private User2Mapper user2Mapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addRequired(User2 user2) {
        user2Mapper.insert(user2);
    }

    @Override
    @Transactional
    public boolean addRequired1(User2 user2) {
        return user2Mapper.insert(user2) == 1;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiredNew(User2 user2) {
        user2Mapper.insert(user2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addRequiredException(User2 user2) {
        user2Mapper.insert(user2);
        throw new RuntimeException();

    }

    @Override
    @Transactional
    public boolean addRequiredException1(User2 user2) {
        user2Mapper.insert(user2);
        try {
            //没有抛ex，不会回滚
            throw new RuntimeException();
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addRequiredNewException(User2 user2) {
        user2Mapper.insert(user2);
        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNested(User2 user2) {
        user2Mapper.insert(user2);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void addNestedException(User2 user2) {
        user2Mapper.insert(user2);
        throw new RuntimeException();
    }
}
