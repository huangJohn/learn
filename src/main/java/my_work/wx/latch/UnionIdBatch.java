package my_work.wx.latch;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import my_work.wx.UnionIdData;
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
public class UnionIdBatch implements Watcher {

    public static final Logger logger = LoggerFactory.getLogger(UnionIdBatch.class);
    private int id;
    private List<String> partitions;
    private CountDownLatch latch;

    public UnionIdBatch(int id, List<String> partitions) {

        this.id = id;
        this.partitions = partitions;
        this.latch = new CountDownLatch(partitions.size());

    }


    @Override
    public void done(List<UnionIdData> data) {

        latch.countDown();

        if (latch.getCount() == 0) {
            logger.info("UnionIdBatch id " + id + " done.");
        }
    }
}
