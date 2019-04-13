package com.zh.learn.design_pattern_test.adapter.adapter_of_class;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class Mobile {

    /**
     * 根据输出标准来具体使用
     *
     * */
    public void charging(Voltage5 voltage5) {
        if (voltage5.output5V() == 5) {
            System.out.println("电压为5V，开始充电");
        } else if (voltage5.output5V() > 5) {
            System.out.println("电压超过5V，小心");
        }
    }

    public static void main(String[] args) {
        Mobile mobile = new Mobile();
        mobile.charging(new VoltageAdapter());
    }
}
