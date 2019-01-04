package design_pattern_test.adapter.adapter_of_obj;

import design_pattern_test.adapter.adapter_of_class.Mobile;
import design_pattern_test.adapter.adapter_of_class.Voltage220;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class Mobile2 {

    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.charging(new VoltageAdater2(new Voltage220()));
    }
}
