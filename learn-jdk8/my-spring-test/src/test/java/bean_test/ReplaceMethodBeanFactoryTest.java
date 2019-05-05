package bean_test;

import bean_test.bean.replace_method_bean.TestChangeMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-30
 */
public class ReplaceMethodBeanFactoryTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:replace-method-test.xml");

        TestChangeMethod bean = context.getBean(TestChangeMethod.class);

        bean.changeMe();
    }

}
