package str;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/20
 */
public class InternTest {

    public static void main(String[] args) {


        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);//1.7下是true，1.6下是false
        System.out.println(s1.intern());

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);//非第一次，s2.intern()实际指向第一次的引用，s2是另外一个堆
        System.out.println(s2.intern());



    }

}
