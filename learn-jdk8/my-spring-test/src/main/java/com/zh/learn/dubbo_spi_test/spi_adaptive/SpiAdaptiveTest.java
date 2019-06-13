package com.zh.learn.dubbo_spi_test.spi_adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-06-14
 */
public class SpiAdaptiveTest {

    public static void main(String[] args) {


        ExtensionLoader<AdaptiveExtension> extensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExtension.class);

        AdaptiveExtension adaptiveExtension = extensionLoader.getAdaptiveExtension();

        //interface spi 配置默认值 dubbo，url中没有key指定且匹配上的，取默认dubbo实现
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("123", url));

        //interface spi默认值 dubbo，方法有注解，url中有key指定，切指定的key和实现类名驼峰.分割匹配，则取对应实现，没有匹配到的取默认实现
        URL url2 = URL.valueOf("test://localhost/test?adaptive.extension=springcloud");
        System.out.println(adaptiveExtension.echo("123", url2));

        //interface spi 默认dubbo, 方法echo打上注解和key，url上有对应key，对key匹配的实现类，驼峰自动分割的key失效，没有匹配的key则取默认spi实现
        URL url3 = URL.valueOf("test://localhost/test?t1=springcloud");
        System.out.println(adaptiveExtension.echo("123", url3));

        URL url4 = URL.valueOf("test://localhost/test?t2=springcloud");
        System.out.println(adaptiveExtension.echo("123", url4));

        //具体的实现类打上Adaptive，url key和默认spi值失效，全部取Adaptive在类上的注解
        //优先级：类大于方法，方法上具体指定key大于"不写的"，没有匹配到则取spi 默认实现


    }


}
