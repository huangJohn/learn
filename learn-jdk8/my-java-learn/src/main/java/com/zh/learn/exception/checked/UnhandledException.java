package com.zh.learn.exception.checked;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019/10/19
 */
public class UnhandledException {

    public static void main(String[] args) {

        //checked ex必须try catch或者throw
        //并且，如果是try catch操作类型要正确，Exception和Throwable另外
//        throw new Exception();

        try {
            System.out.println("123");
        } catch (Exception e) {

        } catch (Throwable throwable) {

        }

        //Exception是checked ex
        //儿子RuntimeExcption是unchecked ex，和其儿子是unchecked ex
        //    比如，NullPointerException和ClassCastException是unchecked ex
        //Error和其子类 unchecked

        //运行时期编译可通过，可以不处理
        throw new NullPointerException();
    }

}
