package concurrency.design.event_driven.usage;

/**
 * @author zhuanghuang
 * @date 2018/10/11
 */

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
