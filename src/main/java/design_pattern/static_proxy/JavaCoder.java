package design_pattern.static_proxy;

import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class JavaCoder implements ICoder {

    private String name;

    public JavaCoder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void implDemands(String demandName) {
        System.out.println(name + " implemented demand : " + demandName + " in Java");
    }
}
