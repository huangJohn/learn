package com.zh.learn.design_patterns.context;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public class QueryFromHttpAction {

    public void execute(Context context) {

        try {
            Thread.sleep(2000L);
            String id = getIdByName(context.getName());
            context.setId(id);
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
