package com.zh.algs.interview.top.search;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/10
 */
public class EatBanana {

    public static void main(String[] args) {
        System.out.println(eatMinSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public static int eatMinSpeed(int[] piles, int h) {

        int maxVal = 1;
        for (int i = 0; i < piles.length; i++) {
            maxVal = Math.max(maxVal, piles[i]);
        }

        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (canEat(mid, piles, h)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static boolean canEat(int mid, int[] piles, int h) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += Math.ceil(piles[i] * 1.0 / mid);
        }
        return sum > h;
    }

}
