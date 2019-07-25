package com.zh.learn.design_patterns.context.threadlocal;

import com.zh.learn.design_patterns.context.Context;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-26
 */
public final class ActionContext {

    private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<Context>() {
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder {
        private final static ActionContext ACTION_CONTEXT = new ActionContext();
    }

    public static ActionContext getInstance() {
        return ContextHolder.ACTION_CONTEXT;
    }

    public Context getContext() {
        return THREAD_LOCAL.get();
    }

}
