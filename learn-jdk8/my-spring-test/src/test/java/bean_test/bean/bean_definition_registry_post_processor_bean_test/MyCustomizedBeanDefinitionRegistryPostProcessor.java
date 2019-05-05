package bean_test.bean.bean_definition_registry_post_processor_bean_test;

import bean_test.bean.beanfactory_post_processor_bean_test.MyBeanFactoryPostProcessorTestBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class MyCustomizedBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        System.out.println("postProcessBeanDefinitionRegistry 执行开始");

        /**
         * Description:可以硬编码方式直接注入
         */

        Class<MyBeanFactoryPostProcessorTestBean> myTestBeanClass = MyBeanFactoryPostProcessorTestBean.class;

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(myTestBeanClass);

        GenericBeanDefinition rawBeanDefinition = (GenericBeanDefinition) builder.getRawBeanDefinition();

        rawBeanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        rawBeanDefinition.getPropertyValues().add("name", "BeanDefinitionRegistryPostProcessor");

        System.out.println("postProcessBeanDefinitionRegistry 我构建的bean的属性name是 : " + rawBeanDefinition.getPropertyValues().get("name"));

        registry.registerBeanDefinition("myBeanFactoryPostProcessorTestBean", rawBeanDefinition);

        System.out.println("postProcessBeanDefinitionRegistry 执行结束");

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("postProcessBeanDefinitionRegistry postProcessBeanFactory 执行开始");
        System.out.println("postProcessBeanDefinitionRegistry postProcessBeanFactory 执行结束");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }

}
