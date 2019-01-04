package design_pattern_test.adapter.adapter_of_class;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class Voltage220 {

    /**
     * 充电器本身看做Adapter，220V交流看做需要被转化的类，5V看做转化后的类，以供系统使用
     */

    private int src = 220;

    public int output220() {
        System.out.println("我是" + src + "V");
        return src;
    }
}
