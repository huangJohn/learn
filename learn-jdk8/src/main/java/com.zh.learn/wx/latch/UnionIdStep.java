package com.zh.learn.wx.latch;

import com.zh.learn.wx.UnionIdData;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-15
 */
@Data
@ToString
@Accessors(chain = true)
public class UnionIdStep implements Watcher {

    public static final Logger logger = LoggerFactory.getLogger(UnionIdStep.class);

    private CountDownLatch latch;

    private UnionIdBatch batch;

    public UnionIdStep(int size, UnionIdBatch batch) {
        this.latch = new CountDownLatch(size);
        this.batch = batch;
    }

    @Override
    public void done(List<UnionIdData> data) {

        latch.countDown();
        if (latch.getCount() == 0) {
            logger.info("UnionIdStep [ in UnionIdBatch id = " + batch.getId() + " ] : done.");
        }
    }
}
