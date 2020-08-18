package com.zh.algs.ds.exercise;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/12
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(LengthOfLCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));

    }

    public static int LengthOfLCS(char[] s1, char[] s2, int n, int m) {

        if (s1 == null || s1.length == 0 || s2 == null || s2.length == 0) {
            return 0;
        }

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if ((i == 0 || j == 0)) {
                    arr[i][j] = 0;
                } else if (s1[i - 1] == s2[j - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[n][m];
    }
}
