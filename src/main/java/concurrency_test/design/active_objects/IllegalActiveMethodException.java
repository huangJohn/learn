package concurrency_test.design.active_objects;

/**
 * @author zhuanghuang
 * @date 2018/10/10
 */

public class IllegalActiveMethodException extends Exception {

    public IllegalActiveMethodException(String message) {
        super(message);
    }
}
