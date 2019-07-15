package com.zh.learn.json_test;

import com.alibaba.fastjson.JSONObject;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-19
 */
public class JsonTest {

    public static void main(String[] args) {


        String s = "{\"result\":\"201\",\"recycle\":false,\"freez\":false,\"ydAccount\":\"13800000000@mobile.163.com\",\"secuEmail\":{\"email\":\"\",\"active\":false},\"realNameSet\":false,\"verifyTime\":\"1463123514\",\"lock\":false,\"ssn\":\"yd.f4baaaffb8fc4ddfa@163.com\",\"passSet\":true,\"msg\":\"ok\",\"lastModifyTime\":1462414386000}";


        Object parse = JSONObject.parse(s);

        System.out.println(parse.toString());

        System.out.println();

        System.out.println(1<<13);
        System.out.println(1 << 26);
    }

}
