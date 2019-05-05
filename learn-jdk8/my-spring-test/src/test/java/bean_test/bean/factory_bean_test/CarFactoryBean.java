package bean_test.bean.factory_bean_test;

import org.springframework.beans.factory.FactoryBean;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-05-02
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    @Override
    public Car getObject() throws Exception {

        Car car = new Car();
        String[] split = carInfo.split(",");
        car.setBrand(split[0]);
        car.setMaxSpeed(Integer.valueOf(split[1]));
        car.setPrice(Double.valueOf(split[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
