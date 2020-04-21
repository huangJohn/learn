package str;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/21
 */
public class InternTest4 {

    public static void main(String[] args) {

        String s = new String("1");//堆上有"1"，scp上有"1"，s指向堆
        s.intern();//发现scp存在，栈变量返回scp上的"1"
        String s2 = "1";//scp上存在1，s2指向scp
        System.out.println(s == s2);//false，一个堆，一个scp
        System.out.println(s.intern() == s2);//true，栈对同一个scp"1"引用

        String s3 = new String("1") + new String("1");
        /**
         * Description:
         * s3指向堆上string，内容11，scp上只有1
         */

        s3.intern();
        /**
         * Description:
         * jdk7，scp上无11，str pool也不存储常量，返回s3的引用，指向s3的引用内容11
         * 与jdk6区别，scp无11，复制一份到perm区的scp上，返回这个引用
         */
        String s4 = "11";//去str pool创建时发现有11的对象引用就是s3
        System.out.println(s3 == s4);//true
    }

}
