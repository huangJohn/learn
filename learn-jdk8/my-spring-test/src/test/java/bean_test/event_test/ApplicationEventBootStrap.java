package bean_test.event_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class ApplicationEventBootStrap {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        TestEvent event = new TestEvent("hello", "消息来了");
        context.publishEvent(event);

    }

}
