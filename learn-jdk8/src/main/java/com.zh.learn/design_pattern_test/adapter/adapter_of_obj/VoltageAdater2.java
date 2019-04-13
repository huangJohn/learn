package com.zh.learn.design_pattern_test.adapter.adapter_of_obj;

import com.zh.learn.design_pattern_test.adapter.adapter_of_class.Voltage220;
import com.zh.learn.design_pattern_test.adapter.adapter_of_class.Voltage5;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class VoltageAdater2  implements Voltage5 {

    private Voltage220 voltage220;

    public VoltageAdater2(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5V() {
        int dst=-1;
        if (null != voltage220) {
            int src = voltage220.output220();
            System.out.println("对象适配器开始工作，开始适配电压");
            dst = src / 44;
            System.out.println("适配电压完成，为"+dst);
        }
        return dst;
    }

}
