package com.zh.learn.serviceimpl;

import com.zh.learn.service.MessageService;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-27
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "hello world";
    }
}
