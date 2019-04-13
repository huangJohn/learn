package com.zh.learn.wx;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-14
 */

public class OpenidData implements Serializable {

    private static final long serialVersionUID = -7604666690218451702L;

    private int total;
    private int count;
    private String nextOpenid;
    private List<String> openidLists = Lists.newArrayList();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNextOpenid() {
        return nextOpenid;
    }

    public void setNextOpenid(String nextOpenid) {
        this.nextOpenid = nextOpenid;
    }

    public List<String> getOpenidLists() {
        return openidLists;
    }

    public void setOpenidLists(List<String> openidLists) {
        this.openidLists = openidLists;
    }

    @Override
    public String toString() {
        return "OpenidData{" +
                "total=" + total +
                ", count=" + count +
                ", nextOpenid='" + nextOpenid + '\'' +
                ", openidLists=" + openidLists +
                '}';
    }
}
