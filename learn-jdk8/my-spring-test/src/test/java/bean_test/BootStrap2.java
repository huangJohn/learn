package bean_test;

import com.zh.learn.mybatis.test.model.User1;
import com.zh.learn.mybatis.test.model.User2;
import com.zh.learn.mybatis.test.service.User1Service;
import com.zh.learn.mybatis.test.service.User2Service;
import com.zh.learn.mybatis.test.service.UserServiceCompose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:springTest-context.xml"})
public class BootStrap2 extends AbstractJUnit4SpringContextTests {

    @Autowired
    private User1Service user1Service;
    @Autowired
    private User2Service user2Service;
    @Autowired
    private UserServiceCompose userServiceCompose;

    @Test(expected = RuntimeException.class)
    public void test_no_trans_required_required_throwEx() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequired(user2);//succ

        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void test_no_trans_required_requiredException() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredException(user2);//fail
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_required_required_throwEx() {
        userServiceCompose.test();
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_required_requiredException() {
        userServiceCompose.test2();
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_required_requiredException_try() {
        userServiceCompose.test3();
    }

    @Test(expected = RuntimeException.class)
    public void test_no_trans_requiredNew_requiredNew_throwEx() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequiredNew(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredNew(user2);//succ

        throw new RuntimeException();
    }

    @Test(expected = RuntimeException.class)
    public void test_no_trans_requiredNew_requiredNewException() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequiredNew(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredNewException(user2);//fail
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_required_requiredNew_requiredNew_throwEx() {
        userServiceCompose.test4();
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_required_requiredNew_requireNewException() {
        userServiceCompose.test5();
    }

}
