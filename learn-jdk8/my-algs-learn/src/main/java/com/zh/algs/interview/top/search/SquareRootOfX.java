package com.zh.algs.interview.top.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/9
 */
public class SquareRootOfX {

    public static void main(String[] args) {
        System.out.println(compute(9));
        System.out.println(compute(5));

    }

    public static int compute(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 0;
        int right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return right;
    }
}
