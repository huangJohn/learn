package str;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/21
 */
public class InternTest2 {


    public static void main(String[] args) {


        // S1 refers to Object in the Heap Area
        String s1 = new String("GFG"); // Line-1

        // S2 refers to Object in SCP Area
        String s2 = s1.intern(); // Line-2

        // Comparing memory locations
        // s1 is in Heap
        // s2 is in SCP
        System.out.println(s1 == s2);//false

        // Comparing only values
        System.out.println(s1.equals(s2));//true

        // S3 refers to Object in the SCP Area
        String s3 = "GFG"; // Line-3

        System.out.println(s2 == s3);//true










    }

}
