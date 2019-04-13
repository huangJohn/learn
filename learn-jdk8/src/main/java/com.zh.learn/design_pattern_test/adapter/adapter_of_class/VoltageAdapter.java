package com.zh.learn.design_pattern_test.adapter.adapter_of_class;

/**
 * @author zhuanghuang
 * @date 2018/6/6
 */

public class VoltageAdapter extends Voltage220 implements Voltage5 {


    /**
     * 保持原有系统功能，增加新的功能
     *缺点，单继承
     * */

    @Override
    public int output5V() {
        int src = output220();
        System.out.println("电压适配器开始工作");
        int dst = src / 44;
        System.out.println("适配完成后输出电压为" + dst);
        return dst;
    }
}
