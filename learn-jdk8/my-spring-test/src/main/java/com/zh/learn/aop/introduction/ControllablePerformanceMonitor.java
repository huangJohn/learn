package com.zh.learn.aop.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/11/23
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private static final long serialVersionUID = 5182798186617592660L;

    // 定义ThreadLocal类型的变量，用于保存性能监视开关状态。 为了解决单实例线程安全的问题，通过ThreadLocal
    // 让每个线程单独使用一个状态
    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();

    @Override
    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        Object obj = null;
        // 对于支持新跟那个监视可控代理，通过判断其状态决定是否开启性能监控功能
        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "."
                    + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;

    }
}
