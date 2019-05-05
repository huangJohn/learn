package bean_test.bean.circle_reference_construct_arg_bean_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-03
 */
public class TestC {

    private TestA testA;

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public void c() {
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
