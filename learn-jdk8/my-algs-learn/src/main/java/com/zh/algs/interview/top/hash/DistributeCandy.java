package com.zh.algs.interview.top.hash;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/7
 */
public class DistributeCandy {

    public static void main(String[] args) {

        int[] candy = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandy(candy));
    }


    public static int distributeCandy(int[] candy) {
        //candy [-100000,100000]
        int[] record = new int[200001];
        for (int i = 0; i < candy.length; i++) {
            record[candy[i] + 100000]++;
        }
        int count = 0;
        for (int i = 0; i < 200001; i++) {
            if (record[i] != 0) {
                count++;
            }
        }
        int half = candy.length / 2;
        return Math.min(count, half);
    }

}
