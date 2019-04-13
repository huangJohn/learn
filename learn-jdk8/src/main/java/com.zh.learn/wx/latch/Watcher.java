package com.zh.learn.wx.latch;

import com.zh.learn.wx.UnionIdData;

import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-15
 */
public interface Watcher {

    void done(List<UnionIdData> data);


}
