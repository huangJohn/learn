package com.zh.learn.design_patterns.context.threadlocal;

import com.zh.learn.design_patterns.context.Context;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-25
 */
public class QueryFromDBAction2 {

    public void execute() {

        try {
            Thread.sleep(1000L);
            String name = "123 " + Thread.currentThread().getName();
            ActionContext.getInstance().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
