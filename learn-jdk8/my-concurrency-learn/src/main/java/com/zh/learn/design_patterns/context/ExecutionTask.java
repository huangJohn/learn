package com.zh.learn.design_patterns.context;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-25
 */
public class ExecutionTask implements Runnable{

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {

        final Context context = new Context();
        queryFromDBAction.execute(context);
        System.out.println("get name from db success");
        queryFromHttpAction.execute(context);
        System.out.println("get id by name from http success");
        System.out.println("name=" + context.getName() + ", id=" + context.getId());
    }
}
