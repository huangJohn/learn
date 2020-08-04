package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class RemoveElementInArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 5, 4, 3, 2};
        System.out.println(removeElement(arr,2));
    }

    public static int removeElement(int[] arr, int val) {
        int j = 0, i = 0;
        int n = arr.length;

        while (n > 0) {
            if (arr[i] != val) {
                if (n - 1 == i) {
                    return j + 1;
                }
                arr[j] = arr[i];
                i++;
                j++;
            } else {
                if (n - 1 == i) {
                    return j;
                }
                i++;
            }
        }
        return 0;
    }

}
