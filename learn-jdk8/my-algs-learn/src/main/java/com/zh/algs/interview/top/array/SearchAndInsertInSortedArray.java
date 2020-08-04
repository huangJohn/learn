package com.zh.algs.interview.top.array;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class SearchAndInsertInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        System.out.println(searchInsert(arr,5));
    }

    public static int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= arr[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
