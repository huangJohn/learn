package bean_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-03
 */
public class CircleReferenceBeanFactoryTest {

    public static void main(String[] args) {

        /**
         * Description:
         * 抛出异常BeanCurrentlyInCreationException
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:circle-ref-bean-test.xml");




    }

}
