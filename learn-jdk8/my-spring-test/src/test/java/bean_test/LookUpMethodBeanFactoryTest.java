package bean_test;

import bean_test.bean.look_up_method_bean.GetBeanClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-30
 */
public class LookUpMethodBeanFactoryTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:look-up-method-test.xml");

        GetBeanClient bean = context.getBean(GetBeanClient.class);

        bean.showMe();
    }

}
