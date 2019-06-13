package com.zh.learn.dubbo_spi_test.spi_activate;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.List;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */
public class SpiActivateTest {

    /**
     * Description:
     * 1. 根据loader.getActivateExtension中的group和搜索到此类型的实例进行比较，
     * 如果group能匹配到，就是我们选择的，也就是在此条件下需要激活的。
     * 2. @Activate中的value是参数是第二层过滤参数（第一层是通过group），在group校验通过的前提下，
     * 如果URL中的参数（k）与值（v）中的参数名同@Activate中的value值一致或者包含，那么才会被选中。
     * 相当于加入了value后，条件更为苛刻点，需要URL中有此参数并且，参数必须有值。
     * 3.@Activate的order参数对于同一个类型的多个扩展来说，order值越小，优先级越高。
     */

    public static void main(String[] args) {

        ExtensionLoader<ActivateExtension> extensionLoader = ExtensionLoader.getExtensionLoader(ActivateExtension.class);
        URL url = URL.valueOf("test://localhost/test");
        //查询组为default_group的ActivateExtension的实现
        List<ActivateExtension> list = extensionLoader.getActivateExtension(url, new String[]{}, "default_group");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
        System.out.println("===============");

        URL url2 = URL.valueOf("test://localhost/test");
        //查询组为group2的ActivateExtension的实现
        List<ActivateExtension> list2 = ExtensionLoader.getExtensionLoader(ActivateExtension.class).getActivateExtension(url2, new String[]{}, "group2");
        System.out.println(list2.size());
        System.out.println(list2.get(0).getClass());
        System.out.println("===============");

        URL url3 = URL.valueOf("test://localhost/test");
        //根据   key = value1, group =  value
        //@Activate(value = {"value1"}, group = {"value"})来激活扩展
        url3 = url3.addParameter("value2", "value");
        System.out.println("url3 : " + url3);
        List<ActivateExtension> list3 = ExtensionLoader.getExtensionLoader(ActivateExtension.class).getActivateExtension(url3, new String[]{}, "value");
        //url上有group值，且key值必须和实现类上Activate指定value一致
        System.out.println(list3.size());
        System.out.println(list3.get(0).getClass());
        System.out.println("===============");

        URL url4 = URL.valueOf("test://localhost/test");
        List<ActivateExtension> list4 = ExtensionLoader.getExtensionLoader(ActivateExtension.class).getActivateExtension(url4, new String[]{}, "order");
        //order属性在list中排序，越小优先级越高
        System.out.println(list4.size());
        System.out.println(list4.get(0).getClass());
        System.out.println(list4.get(1).getClass());
        System.out.println("===============");

    }

}
