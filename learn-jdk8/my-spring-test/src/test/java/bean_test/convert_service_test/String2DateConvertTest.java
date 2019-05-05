package bean_test.convert_service_test;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-05
 */
public class String2DateConvertTest {

    public static void main(String[] args) {


        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new String2DateConverter());

        String number = "2019-05-05 12:12:11";
        Date convert = defaultConversionService.convert(number, Date.class);
        System.out.println(convert);

    }

}
