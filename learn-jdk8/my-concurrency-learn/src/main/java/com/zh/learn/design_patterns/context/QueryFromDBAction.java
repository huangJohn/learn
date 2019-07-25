package com.zh.learn.design_patterns.context;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-25
 */
public class QueryFromDBAction {

    public void execute(Context context) {

        try {
            Thread.sleep(1000L);
            String name = "123 " + Thread.currentThread().getName();
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
