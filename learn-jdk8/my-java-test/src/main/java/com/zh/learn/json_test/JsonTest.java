package com.zh.learn.json_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

        System.out.println("=================");

        String s2 = "{\"userhashId\":\"3c2e339ff1204833263c526215f17b21\",\"minAppType\":1,\"SP-MARKID\":\"59082273_31\",\"share_profit_info\":[\"59082273_557\",\"59082273_550\",\"59082273_543\"]}";
        System.out.println(s2);

        Map map = JSONObject.parseObject(s2, Map.class);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v.toString());
            if (k.equals("share_profit_info")) {
                List v1 = (List) v;
                System.out.println(v1.get(0));
                System.out.println(v1.get(1));
                System.out.println(v1.get(2));
            }
        });

        Map<String, Object> parse1 = (Map<String, Object>) JSONObject.parse(s2);
        parse1.forEach((k, v) -> {
            System.out.println(k + "=" + v.toString());
            if (k.equals("share_profit_info")) {
                List v1 = (List) v;
                System.out.println(v1.get(0));
                System.out.println(v1.get(1));
                System.out.println(v1.get(2));
            }
        });

        Map<String, Object> parse2 = (Map<String, Object>) JSON.parse(s2);
        parse2.forEach((k, v) -> {
            System.out.println(k + "=" + v.toString());
            if (k.equals("share_profit_info")) {
                List v1 = (List) v;
                System.out.println(v1.get(0));
                System.out.println(v1.get(1));
                System.out.println(v1.get(2));
            }
        });

        User user = new User();
        user.setName("123");
        user.setVlaue("abc");

        String s1 = JSON.toJSONString(user);
        System.out.println(s1);

        Map map1 = JSONObject.parseObject(s1, Map.class);
        map1.forEach((k, v) -> {
            System.out.println(k + "=" + v.toString());

        });

        User user1 = JSONObject.parseObject(s1, User.class);
        System.out.println(user1.getName() + "=" + user1.getVlaue());


    }

    private static class User implements Serializable {
        private static final long serialVersionUID = 789691375836888791L;
        private String name;
        private String vlaue;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVlaue() {
            return vlaue;
        }

        public void setVlaue(String vlaue) {
            this.vlaue = vlaue;
        }
    }


}
