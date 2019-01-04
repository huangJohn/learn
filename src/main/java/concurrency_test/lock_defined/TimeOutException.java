package concurrency_test.lock_defined;

/**
 * @author zhuanghuang
 * @date 2018/6/7
 */

public class TimeOutException extends Exception {

    public TimeOutException(String msg) {
        super(msg);
    }
}
