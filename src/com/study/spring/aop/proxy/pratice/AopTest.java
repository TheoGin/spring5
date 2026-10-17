package com.study.spring.aop.proxy.pratice;

import org.junit.Test;

public class AopTest {
    @Test
    public void testTradition() {
        SmartAnimal smartAnimal = new SmartAnimalImpl();
        smartAnimal.getSum(10.0, 2.0);
        System.out.println("================");
        smartAnimal.getSubtract(10.0, 2.0);
    }

    @Test
    public void testDynamicProxy() {
SmartAnimal smartAnimal = new SmartAnimalImpl();
        SmartAnimalProxyProvider proxyProvider = new SmartAnimalProxyProvider(smartAnimal);
        SmartAnimal proxy = proxyProvider.getProxy();
        proxy.getSum(10.0, 2.0);
        System.out.println("================");
        proxy.getSubtract(10.0, 2.0);
    }
}
