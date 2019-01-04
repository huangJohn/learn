package design_pattern_test.dynamic_proxy.cglib;

/**
 * @author zhuanghuang
 * @date 2018/10/18
 */

public class JavaCoder implements ICode {

    private String name;

    public JavaCoder(String name) {
        this.name = name;
    }

//    public JavaCoder() {
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void implDemand(String demandName) {
        System.out.println(this.name + " impl the demand=[" + demandName + "] in Java");
    }
}
