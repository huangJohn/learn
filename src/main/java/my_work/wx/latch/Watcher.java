package my_work.wx.latch;

import my_work.wx.UnionIdData;

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
