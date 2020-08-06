package com.zh.algs.ds.exercise;

import com.zh.algs.sorting.utils.SortingUtils;

import java.util.LinkedList;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/6
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(arr, 3);
        SortingUtils.printArray(ints);
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {

        if (arr == null || arr.length < k || k < 1) {
            return new int[0];
        }

        int n = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();

        int[] res = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && arr[queue.peekFirst()] <= arr[i]) {
                queue.pollFirst();
            }

            queue.addLast(i);

            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }

            if (i >= (k - 1)) {
                res[index++] = arr[queue.peekFirst()];
            }
        }

        return res;
    }

}
