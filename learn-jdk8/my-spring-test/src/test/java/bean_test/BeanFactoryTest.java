package bean_test;

import bean_test.bean.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-29
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");

        assertEquals("testStr", bean.getTestStr());


    }

}
