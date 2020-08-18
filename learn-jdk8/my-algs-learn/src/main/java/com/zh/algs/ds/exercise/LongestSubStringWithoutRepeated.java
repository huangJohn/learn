package com.zh.algs.ds.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/13
 */
public class LongestSubStringWithoutRepeated {

    public static void main(String[] args) {

        String s = "abcdabcaba";
        System.out.println(lengthOfLongestSubStringWithoutRepeated(s.toCharArray()));
    }

    public static int lengthOfLongestSubStringWithoutRepeated(char[] chars) {

        if (chars == null || chars.length == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int right = -1;
        int ans = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                set.remove(chars[i]);
            }

            while (right + 1 < chars.length && !set.contains(chars[right + 1])) {
                set.add(chars[right + 1]);
                right++;
            }

            ans = Math.max(ans, right - i + 1);
        }

        return ans;
    }

}
