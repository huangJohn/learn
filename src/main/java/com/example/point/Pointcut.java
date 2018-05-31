package com.example.point;

import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

/**
 * @author zhuanghuang<zhuanghuang       @       corp.netease.com>
 * @since 2018/5/30
 */

public class Pointcut extends NameMatchMethodPointcut {

    private static final long serialVersionUID = 3990456017285944475L;

    @SuppressWarnings("rawtypes")
    public boolean matches(Method method, Class targetClass) {
        // 设置单个方法匹配
        this.setMappedName("delete");
        // 设置多个方法匹配
        String[] methods = {"delete", "modify"};
        //也可以用“ * ” 来做匹配符号
        // this.setMappedName("get*");
        this.setMappedNames(methods);
        return super.matches(method, targetClass);
    }
}
