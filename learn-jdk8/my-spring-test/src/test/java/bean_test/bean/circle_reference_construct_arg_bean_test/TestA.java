package bean_test.bean.circle_reference_construct_arg_bean_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-03
 */
public class TestA {

    private TestB testB;

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public void a() {
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }

}
