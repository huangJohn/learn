package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    }
}
