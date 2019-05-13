package bean_test;

import bean_test.bean.factory_bean_test.Car;
import bean_test.bean.factory_bean_test.CarFactoryBean;
import bean_test.bean.start_container.MyTestBean;
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
public class StartContainerBeanFactoryTest {

    @Test
    public void testSimpleLoad() {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));

        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");

        assertEquals("testStr", bean.getTestStr());

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car.getMaxSpeed());

        CarFactoryBean carFactoryBean = (CarFactoryBean) beanFactory.getBean("&car");
        Car car1 = null;
        try {
            car1 = carFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(car1.getMaxSpeed());
    }

}
