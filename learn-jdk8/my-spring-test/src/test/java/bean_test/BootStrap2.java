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
@ContextConfiguration(locations = {"classpath*:springTest-context.xml"})
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

//        throw new RuntimeException();//外部无事务，内部走独立事务，ex无影响
    }

    @Test(expected = RuntimeException.class)
    public void test_no_trans_required_requiredException() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addRequired(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addRequiredException(user2);//fail，外部无事务，内部独立事务，user1成功，user2独立事务自己ex失败
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

    @Test(expected = RuntimeException.class)
    public void test_with_trans_required_requiredNew_requireNewException_try() {
        userServiceCompose.test6();
    }

    @Test(expected = RuntimeException.class)
    public void test_no_trans_requiredNested_requiredNested_throwEx() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addNested(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addNested(user2);//succ

        throw new RuntimeException();//外部无事务，内部走独立事务，ex无影响
    }

    @Test(expected = RuntimeException.class)
    public void test_no_trans_requiredNested_requiredNestedException() {
        User1 user1 = new User1();
        user1.setName("zhangsan");
        user1Service.addNested(user1);//succ

        User2 user2 = new User2();
        user2.setName("lisi");
        user2Service.addNestedException(user2);//fail

    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_requireNested_requireNested_requireNestedException_try() {
        userServiceCompose.test7();
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_requireNested_requireNested_requireNestedException() {
        userServiceCompose.test8();
    }

    @Test(expected = RuntimeException.class)
    public void test_with_trans_requireNested_requireNested_throwEx() {
        userServiceCompose.test9();
    }

    /**
     * Description:
     * REQUIRED和NESTED两种传播行为修饰的内部方法均属于外部方法事务，如果外部方法直接抛出异常，这两种传播行为
     * 修饰的内部方法均被回滚，但是REQUIRED是加入型事务，和外部方法属于同一个事务，一旦REQUIRED事务抛出异常且被回滚，
     * 外部事务方法也被回滚，而NESTED事务属于外部事务的子事务，有自己的内部savapoint，所以NESTED事务抛出异常被回滚，
     * 外部事务中有处理catch操作，将不影响外部事务
     *
     * NESTED和REQUIRED_NEW都可做到内部方法回滚而不影响外部事务，但是NESTED是嵌套事务，外围事务回滚了，NESTED事务必然
     * 回滚，而REQUIRED_NEW是内部新开事务，与外部事务独立，外部事务回滚不影响内部事务提交
     */

    @Test
    public void test_return() {
        boolean b = userServiceCompose.test10();
        System.out.println(b);
    }
}
