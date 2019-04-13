package com.zh.learn.wx.latch;

import com.alibaba.fastjson.JSON;
import com.zh.learn.wx.UnionIdData;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-15
 */
public class WriteUnionIdTask implements Runnable {

    public static final Logger logger = LoggerFactory.getLogger(WriteUnionIdTask.class);

    private List<UnionIdData> data;

    private UnionIdStep step;

    private String filePath;

    public WriteUnionIdTask(List<UnionIdData> data, UnionIdStep step, String filePath) {

        this.step = step;
        this.data = data;
        this.filePath = filePath;
    }

    @Override
    public void run() {

        File file = new File(filePath);

        if (CollectionUtils.isNotEmpty(data)) {

            for (UnionIdData unionIdData : data) {

                if (unionIdData.getOpenid() != null) {

                    if (unionIdData.getUnionId() != null) {

                        try {
                            FileUtils.write(file, unionIdData.getOpenid() + "\t" + unionIdData.getUnionId() + "\n", Charset.forName("UTF-8"), true);
                        } catch (IOException e) {
                            logger.error("error", e);
                        }

                    } else {

                        logger.info("unionIdData has null uid. unionIdData={}", JSON.toJSONString(unionIdData));

                        try {
                            FileUtils.write(file, unionIdData.getOpenid() + "\t" + "null" + "\n", Charset.forName("UTF-8"), true);
                        } catch (IOException e) {
                            logger.error("error", e);
                        }
                    }


                }

            }

            step.done(data);

        } else {
            logger.error("data is null");
            throw new RuntimeException("data is null");
        }
    }
}
