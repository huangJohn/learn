package bean_test;

import com.zh.learn.mybatis.test.model.User1;
import com.zh.learn.mybatis.test.service.UserInnerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/12/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springTest-context.xml"})
public class BootStrap3 {

    @Autowired
    private UserInnerService userInnerService;

    @Test
    public void testInner() {
        User1 user1 = new User1();
        user1.setName("zhuanghuang");
        userInnerService.addUser1(user1);
    }

}
