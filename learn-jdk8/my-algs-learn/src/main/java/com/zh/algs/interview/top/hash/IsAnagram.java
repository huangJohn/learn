package com.zh.algs.interview.top.hash;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/7
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("abcd", "adbc"));
        System.out.println(isAnagram("abcd", "adfc"));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
