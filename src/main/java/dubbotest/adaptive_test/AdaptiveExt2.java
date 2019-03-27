package dubbotest.adaptive_test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-27
 */

@SPI("dubbo")
public interface AdaptiveExt2 {

//    @Adaptive({"t"})
    @Adaptive
    String echo(URL url, String msg);
}
