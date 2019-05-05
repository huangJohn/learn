package bean_test.bean.factory_bean_test;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-02
 */

@Data
@ToString
@Accessors(chain = true)
public class Car {


    private int maxSpeed;
    private String brand;
    private double price;


}
