package concept.classloader_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-09
 */
public class Child extends Parent{

    static {

        System.out.println("child will be initialed");
    }

    public static int x = 10;



}
