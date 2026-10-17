package com.study.spring.aop.proxy;

import org.junit.Test;

public class AopTest {
    @Test
    public void testTradition() {
        Vehicle car = new Car();
        car.run();

        Vehicle ship = new Ship();
        ship.run();
    }

    @Test
    public void testDynamicProxy() {
        Vehicle vehicle = new Car();
        VehicleProxyProvider vehicleProxyProvider = new VehicleProxyProvider(vehicle);
        Vehicle proxy = vehicleProxyProvider.getProxy();
        // proxy.run();
        String flyResult = proxy.fly(1000);
        System.out.println("flyResult: " + flyResult);
    }
}
