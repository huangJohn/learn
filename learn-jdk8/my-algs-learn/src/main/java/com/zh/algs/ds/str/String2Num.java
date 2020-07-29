package com.zh.algs.ds.str;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/30
 */
public class String2Num {

    private Map<String, String[]> map;

    private static final String START = "start";
    private static final String SIGNED = "signed";
    private static final String IN_NUM = "in_number";
    private static final String END = "end";

    String state = START;
    public int sign = 1;
    public long ans = 0;

    public String2Num() {
        this.map = new HashMap<>();
        map.put(START, new String[]{START, SIGNED, IN_NUM, END});
        map.put(SIGNED, new String[]{END, SIGNED, IN_NUM, END});
        map.put(IN_NUM, new String[]{END, END, IN_NUM, END});
        map.put(END, new String[]{END, END, END, END});
    }

    public static void main(String[] args) {

        String2Num string2Num = new String2Num();
        String s = "   -123199";

        System.out.println(string2Num.str2Int(s));
    }

    public int str2Int(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            get(c);
        }
        return ((int) ans) * sign;
    }

    public void get(char c) {
        state = map.get(state)[getIndex(c)];
        if (state.equals(IN_NUM)) {
            ans = ans * 10 + c - '0';
            if (sign == 1) {
                ans = Math.min(ans, Integer.MAX_VALUE);
            } else {
                ans = Math.min(ans, -(long) Integer.MIN_VALUE);
            }
        } else if (state.equals(SIGNED)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getIndex(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (c >= '0' && c <= '9') {
            return 2;
        } else {
            return 3;
        }
    }
}
