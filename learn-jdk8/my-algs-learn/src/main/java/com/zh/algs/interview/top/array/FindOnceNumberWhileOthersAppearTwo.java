package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class FindOnceNumberWhileOthersAppearTwo {

    public static int findSingle(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 5, 3, 6};
        System.out.println(findSingle(arr));
    }
}
