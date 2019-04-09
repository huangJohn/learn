package concept.classloader_test;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-09
 */
public class Parent {

    static {


        System.out.println("parent is initialed");

    }

    public static int y = 100;

}
