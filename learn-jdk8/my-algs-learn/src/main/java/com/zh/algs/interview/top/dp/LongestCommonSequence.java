package com.zh.algs.interview.top.dp;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/9
 */
public class LongestCommonSequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lengthOfLCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lengthOfLCS2(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));

    }

    public static int lengthOfLCS2(char[] a, char[] b, int n, int m) {
        int[][] nm = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    nm[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    nm[i][j] = nm[i - 1][j - 1] + 1;
                } else {
                    nm[i][j] = Math.max(nm[i - 1][j], nm[i][j - 1]);
                }
            }
        }

        return nm[n][m];
    }

    public static int lengthOfLCS(char[] a, char[] b, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (a[n - 1] == b[m - 1]) {
            return 1 + lengthOfLCS(a, b, n - 1, m - 1);
        } else {
            return Math.max(lengthOfLCS(a, b, n - 1, m), lengthOfLCS(a, b, n, m - 1));
        }

    }

}
