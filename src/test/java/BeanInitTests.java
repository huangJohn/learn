import com.example.entity.Customer;
import com.example.entity.Customer2;
import com.example.entity.Customer3;
import com.example.entity.Customer4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class BeanInitTests {

    private ApplicationContext ac = null;

    @Before
    public void setUp() throws Exception {
        System.out.println("......junit单元测试是方法之前执行......");
        // 首先读取配置文件，配置文件中的bean将会保存到ApplicationContext的实例中
        ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    @After
    public void tearDown() throws Exception {
        System.out.println("......junit单元测试是方法之后执行......");
    }

    @Test
    public void test1() {
        Customer customer = (Customer)ac.getBean("customer2");
        System.out.println(customer);
    }


    @Test
    public void test2() {
        Customer2 customer = (Customer2)ac.getBean("customer7");
        System.out.println(customer);
    }

    @Test
    public void test3() {
        Customer2 customer = (Customer2)ac.getBean("customer8");
        System.out.println(customer);
    }

    @Test
    public void test4() {
        //修改Customer2.java中的toString方法。移除其中的Record属性的Set/Get方法，防止空指针异常。
        Customer2 customer = (Customer2)ac.getBean("customer9");
        System.out.println(customer);
    }

    @Test
    public void test5() {
        Customer3 customer = (Customer3)ac.getBean("customer10");
        System.out.println(customer);
    }

    @Test
    public void test6() {
        Customer4 customer = (Customer4)ac.getBean("customer11");
        System.out.println(customer);
    }
}