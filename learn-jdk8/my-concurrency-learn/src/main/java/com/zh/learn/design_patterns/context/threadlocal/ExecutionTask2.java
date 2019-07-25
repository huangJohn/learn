package com.zh.learn.design_patterns.context.threadlocal;

import com.zh.learn.design_patterns.context.Context;
import com.zh.learn.design_patterns.context.QueryFromDBAction;
import com.zh.learn.design_patterns.context.QueryFromHttpAction;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-25
 */
public class ExecutionTask2 implements Runnable{

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {

        Context context = ActionContext.getInstance().getContext();
        queryFromDBAction.execute(context);
        System.out.println("get name from db success");
        queryFromHttpAction.execute(context);
        System.out.println("get id by name from http success");
        System.out.println("name=" + context.getName() + ", id=" + context.getId());
    }
}
