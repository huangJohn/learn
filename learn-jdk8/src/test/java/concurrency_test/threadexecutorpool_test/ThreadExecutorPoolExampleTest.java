package concurrency_test.threadexecutorpool_test;

import com.zh.learn.concurrency_test.threadexecutorpool_test.ThreadExecutorPoolExample;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;
import static org.junit.Assert.*;

public class ThreadExecutorPoolExampleTest {

    private ThreadExecutorPoolExample example;

    @Before
    public void setUp() throws Exception {
        example = new ThreadExecutorPoolExample();
    }

    @After
    public void tearDown() throws Exception {
        example = null;
    }

    /**
     * Description:
     * @throws IllegalArgumentException if one of the following holds:<br>
     *      *         {@code corePoolSize < 0}<br>
     *      *         {@code keepAliveTime < 0}<br>
     *      *         {@code maximumPoolSize <= 0}<br>
     *      *         {@code maximumPoolSize < corePoolSize}
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorParamWrong() {

        example.create(2, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        fail("not run here");
    }
}