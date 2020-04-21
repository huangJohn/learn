package str;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/21
 */
public class InternTest5 {

    public static void main(String[] args) {




        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";//没有11，scp创建
        String intern = s3.intern();//已经有11了，不做scp 11指向s3的引用
        System.out.println(s3 == s4);
        System.out.println(intern == s4);
    }


}
