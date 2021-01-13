package com.zh.learn.mybatis.test.service;

import com.zh.learn.mybatis.test.dao.User1Mapper;
import com.zh.learn.mybatis.test.model.User1;
import gnu.trove.impl.hash.THashIterator;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/12/17
 */
@Service
public class UserInnerService {

    @Autowired
    private User1Mapper user1Mapper;

    public void addUser1(User1 user1) {
        UserInnerService service = getService();
        if (service == null) {
            throw new RuntimeException("获取当前代理service失败");
        }

        service.addUser1ByInner(user1);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addUser1ByInner(User1 user1) {
        user1Mapper.insert(user1);
        throw new RuntimeException("ex");
    }

    public UserInnerService getService() {
        return AopContext.currentProxy() != null ? (UserInnerService) AopContext.currentProxy() : null;
    }


}
