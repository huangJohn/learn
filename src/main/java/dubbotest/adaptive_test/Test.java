package dubbotest.adaptive_test;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.utils.StringUtils;

import java.util.Arrays;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-03-27
 */
public class Test {

    public static void main(String[] args) {

        /**
         * Description:
         * 1. 在类上加上@Adaptive注解的类，是最为明确的创建对应类型Adaptive类。所以他优先级最高。
         * 2. @SPI注解中的value是默认值，如果通过URL获取不到关于取哪个类作为Adaptive类的话，就使用这个默认值，当然如果URL中可以获取到，就用URL中的。
         * 3. 可以再方法上增加@Adaptive注解，注解中的value与链接中的参数的key一致，链接中的key对应的value就是spi中的name,获取相应的实现类。
         */

        ExtensionLoader<AdaptiveExt2> extensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);

        AdaptiveExt2 adaptiveExtension = extensionLoader.getAdaptiveExtension();

        URL url = URL.valueOf("test://localhost/test");//类没有被注解adaptive，方法被注解，没有指定key，则尝试在url上寻找key，其实是没有，于是找到默认dubbo实现

        System.out.println(adaptiveExtension.echo(url, "d"));

        URL url2 = URL.valueOf("test://localhost/test?adaptive.ext2=cloud");//类没被注解，方法被注解修饰了，没传key，默认使用camelToSplitName算法获取key，从url上找到对应key，获取spi标签找到实现
        System.out.println(adaptiveExtension.echo(url2, "d"));

        URL url3 = URL.valueOf("test://localhost/test?adaptive.ext2=cloud");//倘如类如果被adaptive修饰了，直接获取实现,不管url显示传key了
        System.out.println(adaptiveExtension.echo(url3, "d"));

        URL url4 = URL.valueOf("test://localhost/test?t=cloud");//类没被注解，方法注解穿了key，且被指定list顺序keys，url上找到则获取对应实现，没有则默认
        System.out.println(adaptiveExtension.echo(url4, "d"));


        Class<AdaptiveExt2> adaptiveExt2Class = AdaptiveExt2.class;
        String splitName = StringUtils.camelToSplitName(adaptiveExt2Class.getSimpleName(), ".");
        String[] value = new String[]{splitName};
        Arrays.stream(value).forEach(m -> System.out.println(m));
    }

}
