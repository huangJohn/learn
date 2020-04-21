package str;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/21
 */
public class InternTest3 {

    public static void main(String[] args) {

        // S1 refers to Object in the Heap Area
        String s1 = new String("GFG"); // Line-1

        // S2 now refers to Object in SCP Area
        String s2 = s1.concat("GFG"); // Line-2
        /**
         * Description:
         * 注意，s1+"asd"形式，+，jvm对str处理会在堆上创建Stringuilder类，append方法处理完调toString方法转为String堆实例
         * str本身的concat方法不会，仍然在scp上创建
         */

        // S3 refers to Object in SCP Area
        String s3 = s2.intern(); // Line-3

        System.out.println(s2 == s3);//true

        // S4 refers to Object in the SCP Area
        String s4 = "GFGGFG"; // Line-4

        System.out.println(s3 == s4);//ture

    }

}
