package com.zh.learn.design_patterns.context.threadlocal;

import com.zh.learn.design_patterns.context.Context;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class QueryFromHttpAction2 {

    public void execute() {

        try {
            Thread.sleep(2000L);
            String id = getIdByName(ActionContext.getInstance().getContext().getName());
            ActionContext.getInstance().getContext().setId(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private String getIdByName(String name) {
        try {
            Thread.sleep(3000L);
            return "asd " + Thread.currentThread().getName();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        }

    }
}
