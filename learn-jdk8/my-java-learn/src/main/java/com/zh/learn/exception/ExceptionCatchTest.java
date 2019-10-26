package com.zh.learn.exception;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-17
 */
public class ExceptionCatchTest {

    public static void main(String[] args) {

        ExceptionCatchTest exceptionCatchTest = new ExceptionCatchTest();

        try {
            exceptionCatchTest.doSomething(-1);
        } catch (MyRpcException e) {
            System.out.println("MyRpcException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException===" + e.getClass());
        } catch (Exception e) {
            System.out.println("Exception");
        } catch (Throwable t) {
            System.out.println("Throwable");
        }
    }

    public void doSomething(int x) throws Throwable {
        if (x < 0) {
            throw new Exception("x can not < 0");
        }
        System.out.println("do doSomething");
        if (x % 2 == 0) {
            throw new MyRpcException();
        } else {
            if (x == 1) {
                throw new Throwable();
            } else {
                throw new RuntimeException();
            }
        }
    }

}
