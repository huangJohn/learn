package com.zh.algs.interview.top.hash;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/7
 */
public class RansomMagazine {

    public static void main(String[] args) {
        System.out.println(isFind("ab", "aba"));
        System.out.println(isFind("abc", "aba"));

    }

    public static boolean isFind(String ransom, String magazine) {
        int[] record = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransom.length(); i++) {
            record[ransom.charAt(i) - 'a']--;
            if (record[ransom.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
