package bean_test.bean.look_up_method_bean;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-30
 */
public abstract class GetBeanClient {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();

}
