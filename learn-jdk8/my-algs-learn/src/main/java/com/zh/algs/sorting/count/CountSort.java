package com.zh.algs.sorting.count;

import com.zh.algs.sorting.utils.SortingUtils;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-19
 */
public class CountSort {

    public static void sortForChars(char[] arr) {
        int n = arr.length;
        //辅助
        char[] output = new char[n];
        //0-255
        int[] count = new int[256];
        //init
        for (int i = 0; i < 256; i++) {
            count[i] = 0;
        }
        //到0的距离相等的+1
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        //保证稳定性,到0的距离为i的数有count[n]-count[n-1]个
        for (int i = 1; i <= 255; i++) {
            count[i] = count[i] + count[i - 1];
        }
        //反取
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            //计数减1
            count[arr[i]]--;
        }
        //赋值
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void sort(int[] arr) {
        //获取最大值
        int max = Arrays.stream(arr).max().getAsInt();
        //获取最小值
        int min = Arrays.stream(arr).min().getAsInt();
        //index 0-range-1
        int range = max - min + 1;
        //new count[]
        int[] count = new int[range];
        int n = arr.length;
        //辅助数组
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            //和mini值相对距离
            //相对距离相同的，代表出现相同数字，个数+1
            count[arr[i] - min]++;
        }

        //增序，保证稳定性，同一个数先出现的，排在left
        for (int i = 1; i < count.length; i++) {
            //到min点的距离为i的数有count[n]-count[n-1]个
            count[i] = count[i] + count[i - 1];
        }

        //倒取，计数减1，保证稳定性
        //数组以0开始index
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            //计数减1
            count[arr[i] - min]--;
        }
        //赋值
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }

        //4,3,2,3,7,1
        //0-1-2-3-4-5-6  相对距离
        //1=1=2=1=0=0=1  个数
        //1,2,4,5,5,5,6  距离1有1个，距离有2个，。。。
    }

    public static void sortByDesc(int[] arr) {
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];
        //降序
        //和max值相对距离
        //相对距离相同的，代表出现相同数字，个数+1
        for (int i = 0; i < n; i++) {
            count[max - arr[i]]++;
        }
        //降序，保证稳定性，同一个数先出现的，排在left
        for (int i = 1; i < range; i++) {
            count[i] = count[i] + count[i - 1];
        }
        //同一个数，先出现的排在left
        //2,7,2
        //max 7
        //min 2
        //0-1-2-3-4-5
        //1=0=0=0=0=2
        //1-1-1-1-1-3
        //倒取，计数减1，保证稳定性
        for (int i = n - 1; i >= 0; i--) {
            output[count[max - arr[i]] - 1] = arr[i];
            count[max - arr[i]]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'g', 't', 'r', 't', 'a'};
        SortingUtils.printArray(arr);
        sortForChars(arr);
        SortingUtils.printArray(arr);
        int[] arr1 = {-5, -10, 0, -3, 8, 5, -1, 10, -1, -3, 0};
        SortingUtils.printArray(arr1);
        sort(arr1);
        SortingUtils.printArray(arr1);
        sortByDesc(arr1);
        SortingUtils.printArray(arr1);

    }

}
