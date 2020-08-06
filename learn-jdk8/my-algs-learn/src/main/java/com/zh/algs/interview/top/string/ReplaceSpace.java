package com.zh.algs.interview.top.string;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/6
 */
public class ReplaceSpace {

    public static void main(String[] args) {


        String s = "hello  world .  a";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {

        char[] chars = s.toCharArray();
        int count = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        char[] charsNew = new char[length + count * 2];
        for (int i = 0, j = 0; i < charsNew.length && j < chars.length; i++, j++) {
            if (chars[j] != ' ') {
                charsNew[i] = chars[j];
            } else {
                charsNew[i] = '%';
                charsNew[i + 1] = '2';
                charsNew[i + 2] = '0';
                i = i + 2;
            }
        }

        return new String(charsNew);


    }


}
