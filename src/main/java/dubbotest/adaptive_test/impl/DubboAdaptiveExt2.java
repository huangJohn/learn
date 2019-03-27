package dubbotest.adaptive_test.impl;

import com.alibaba.dubbo.common.URL;
import dubbotest.adaptive_test.AdaptiveExt2;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-27
 */
public class DubboAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(URL url, String msg) {
        return "dubbo";
    }
}
