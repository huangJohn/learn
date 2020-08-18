package com.zh.algs.interview.top.string;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/13
 */
public class LongestPalindromeString {

    public static void main(String[] args) {

        String s = "abcbbaa";
        System.out.println(longestPalindromeStr(s));
    }


    public static String longestPalindromeStr(String s) {

        int max = 0;
        String res = "";

        if (s.length() > 0) {
            res = s.charAt(0) + "";
        }

        for (int i = 0; i < s.length(); i++) {

            //奇数串
            int l = i;
            int r = i;
            while (l >= 0 && r <= s.length() - 1) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            if (r - l + 1 > max) {
                max = r - l + 1;
                res = s.substring(l + 1, r);
            }

            //偶数串
            l = i;
            r = i + 1;
            while (l >= 0 && r <= s.length() - 1) {
                if (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            if (r - l + 1 > max) {
                max = r - l + 1;
                res = s.substring(l + 1, r);
            }
        }
        return res;
    }

}
