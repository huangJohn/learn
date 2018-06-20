package test;

import java.util.*;

/**
 * @author zhuanghuang
 * @since 2018/5/31
 */

public class Test {
    public static void main(String[] args) {
        System.out.println("123");


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            Integer next = it.next();
            System.out.println(next);
            it.remove();
        }

        System.out.println("=======================");
        list.forEach(s -> {
            System.out.println(s);
        });

        System.out.println(System.currentTimeMillis());

        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        System.out.println(getSecondTimestamp(date));
    }


    public static int getSecondTimestamp(Date date){
        if (null == date) {
            return 0;
        }
        String timestamp = String.valueOf(date.getTime());
        int length = timestamp.length();
        if (length > 3) {
            return Integer.valueOf(timestamp.substring(0,length-3));
        } else {
            return 0;
        }
    }
}
