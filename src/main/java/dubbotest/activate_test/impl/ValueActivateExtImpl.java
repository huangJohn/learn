package dubbotest.activate_test.impl;

import com.alibaba.dubbo.common.extension.Activate;
import dubbotest.activate_test.ActivateExt1;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-28
 */
@Activate(value = {"value1"}, group = {"value"})//value1指定了url key，url 对应的v不为空，该扩展就会被激活
public class ValueActivateExtImpl implements ActivateExt1 {

    @Override
    public String echo(String msg) {
        return "value";
    }
}
