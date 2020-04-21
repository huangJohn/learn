package str;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/21
 */
public class StringTest {


    public static void main(String[] args) {


        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);//两个scp上的引用,true
        System.out.println(str1.equals(str2));

        str1 = new String("abc");
        System.out.println(str1 == str2);//1个对上，1个scp上,false
        System.out.println(str1.equals(str2));


        str1 = "a" + "b" + "c";
        System.out.println(str1 == str2);//三个常量，在编译器，根据java字符优化机制，等效于abc,true
        System.out.println(str1.equals(str2));

        str1 = "ab";
        String str3 = str1 + "c";
        System.out.println(str3 == str2);//变量拼接常量，拼接有StringBuilder或者StringBuffer类append操作，内存
        //堆上有StringBuilder对象，在调用toString转为堆上String对象，str3实际指向堆上String，内容是abc。false
        System.out.println(str3.equals(str2));


    }

}
