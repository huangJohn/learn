package dubbotest.adaptive_test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * Description:@Adaptive 基本上所有类型的动态导入都是使用adaptive,使用范围极广。
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-27
 */

@SPI("dubbo")
public interface AdaptiveExt2 {

    @Adaptive({"t22"})
//    @Adaptive
    String echo(URL url, String msg);
}
