package bean_test;

import bean_test.bean.beanfactory_post_processor_bean_test.MyBeanFactoryPostProcessorTestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class BootStrap {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "beanfactory-post-processor-test.xml");

        System.out.println(context.getBean("myBeanFactoryPostProcessorTestBean") +  "--" + ((MyBeanFactoryPostProcessorTestBean)context.getBean("myBeanFactoryPostProcessorTestBean")).getName());




    }

}
