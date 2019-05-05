package bean_test.bean.beanfactory_post_processor_bean_test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MyCustomizedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor test BeanFactoryPostProcessor");

        /**
         * Description:
         * 对注入的bean修改元数据
         */

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("myBeanFactoryPostProcessorTestBean");
        System.out.println("BeanFactoryPostProcessor 修改bean的属性name值");
        System.out.println(beanDefinition.getPropertyValues().add("name", "zhuanghuang"));
    }
}
