package concept.classloader_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-09
 */
public class NotInitializationTest {

    public static void main(String[] args) {

//        System.out.println(Child.x);//调用了子类静态变量，由于继承父类，导致父类初始化

        System.out.println(Child.y);//子类直接访问父类静态变量，并不会导致子类初始化，只父类初始化
    }

}
