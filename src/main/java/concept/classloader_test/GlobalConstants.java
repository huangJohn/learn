package concept.classloader_test;

import java.util.Random;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-04-09
 */
public class GlobalConstants {

    static {

        System.out.println("GlobalConstants will be initialed");
    }

    public final static int MAX = 10;//其他类使用MAX变量不会导致此类初始化，MAX是一个静态常量

    public final static int RANDOM = new Random().nextInt();//其他访问RANDOM会导致此类的初始化，因为随机函数计算出的，类的加载、连接无法对其进行计算，需要初始化后才可以计算

}
