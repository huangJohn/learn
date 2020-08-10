package com.zh.algs.interview.top.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/10
 */
public class LongestSubStringWithoutRepeated {

    public static void main(String[] args) {

        System.out.println(longestSubStringWithoutRepeated("abcdabcdddddd"));
    }

    public static int longestSubStringWithoutRepeated(String s) {

        Set<Character> set = new HashSet<>();
        int ans = 0;
        int right = -1;

        for (int i = 0; i < s.length(); i++) {

            if (i != 0) {
                set.remove(s.charAt(i));
            }

            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }

            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

}
