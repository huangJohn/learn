package com.zh.learn.copy_test;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/1/3
 */

@Data
@ToString
public class User {

    private int id;

    private String username;

    private String sex;

    private Date birthday;

    private String address;

    private Person person;



}
