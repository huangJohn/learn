package com.example.service;

import com.example.girl.Girl;

/**
 * @author zhuanghuang
 * @date 2018/5/28
 */
public class GetMarried {

    private Girl girl;

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public void getMarried() {
        //....
        girl.sayYes();
    }
}
