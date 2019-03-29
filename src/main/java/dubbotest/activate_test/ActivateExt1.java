package dubbotest.activate_test;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * Description:@Activate
 * 主要用在filter上，有的filter需要在provider边需要加的，有的需要在consumer边需要加的，
 * 根据URL中的参数指定，当前的环境是provider还是consumer，运行时决定哪些filter需要被引入执行。
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-28
 */

@SPI
public interface ActivateExt1 {

    String echo(String msg);

}
