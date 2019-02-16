package com.design.pattern.proxy;

import com.design.pattern.proxy.Car;
import com.design.pattern.proxy.CarLorProxy;
import org.junit.Test;

/**
 * @author Devonmusa
 * @Describetion
 * @date 2017年2月25日
 */
public class CarLogProxyTest {

    @Test
    public void test() {
        Car car = new Car();
        CarLorProxy carLorProxy = new CarLorProxy(car);
        carLorProxy.move();
    }

}
