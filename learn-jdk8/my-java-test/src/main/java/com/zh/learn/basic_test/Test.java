package com.zh.learn.basic_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/28
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        String s = "7.21";
        System.out.println(NumberUtils.isNumber(s));

        String s1 = "-777";
        System.out.println(Integer.valueOf(s1));

        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        ArrayList<Integer> integers = Lists.newArrayList(1, 23, 23, 5);
        integers.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).forEach(System.out::println);

        Timestamp timestamp = new Timestamp(1593948101096L);
        System.out.println(timestamp);

        long l = (System.currentTimeMillis() - timestamp.getTime()) / 24 / 3600 / 1000;


        String js = "{\"s\":[\"123\",\"456\"]}";
        JSONObject jsonObject = JSONObject.parseObject(js);
        JSONArray jsonArray = jsonObject.getJSONArray("\"s\"".replaceAll("\"",""));
        System.out.println(jsonArray);
        List<String> strings = jsonArray.toJavaList(String.class);
        for (String s2 : strings) {
            if (s2.equals("123")) {
                System.out.println(true);
            }
        }
        System.out.println(strings);


        String scope = "vip-third-mobile";
        String[] split = StringUtils.split(scope, ",");
        List<String> list = Arrays.asList(split);
        System.out.println(list);

    }
}
