package bean_test.bean.circle_reference_construct_arg_bean_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-03
 */
public class TestB {

    private TestC testC;

    public TestB(TestC testC) {
        this.testC = testC;
    }

    public void b() {

        testC.c();
    }

    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }
}
