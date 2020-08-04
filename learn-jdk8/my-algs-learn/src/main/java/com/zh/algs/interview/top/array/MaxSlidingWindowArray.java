package com.zh.algs.interview.top.array;

import com.zh.algs.sorting.utils.SortingUtils;

import java.util.LinkedList;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class MaxSlidingWindowArray {

    public static void main(String[] args) {

        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(arr, 3);
        SortingUtils.printArray(ints);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < k || k < 1) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            //双向队列保证单调递减
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.addLast(i);

            //滑动串口已经略过队列头元素，需移除
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }

            //窗口长度达到k，记录最大值
            if (i >= (k - 1)) {
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
