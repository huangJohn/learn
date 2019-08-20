package com.zh.algs.sorting.bucket;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.zh.algs.sorting.utils.SortingUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-08-20
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        boolean flag = true;
        //random array
        for (int i = 0; i < arr.length; i++) {
            Random rd = new Random();
            arr[i] = rd.nextInt(1000);
        }
        System.out.println("Random Array :");
        System.out.println(Arrays.toString(arr));
        System.out.println("Bucket Sort :");
        //桶排序开始
        ArrayList<ArrayList<Integer>> sort = sort(arr);
        ArrayList list2 = new ArrayList();
        sort.forEach(list->{
            list.forEach(integer -> {
                if (integer != null) {
                    list2.add(integer);
                }
            });
        });
        System.out.println(list2.toString());
    }

    public static ArrayList<ArrayList<Integer>>  sort(int[] arr) {

        int n = arr.length;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int bucketSize = (max - min) / n + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int index = (arr[i] - min) / n;
            buckets.get(index).add(arr[i]);
        }

        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        return buckets;
    }

}
