package com.study.spring.aop.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class VehicleProxyProvider {

    private Vehicle targetVehicle;

    public VehicleProxyProvider(Vehicle targetVehicle) {
        this.targetVehicle = targetVehicle;
    }

    public Vehicle getProxy() {
        ClassLoader classLoader = this.targetVehicle.getClass().getClassLoader();
        Class<?>[] interfaces = this.targetVehicle.getClass().
                getInterfaces();
        // System.out.println("interfaces: " + interfaces);

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("交通工具开始运行了");
                Object invokeResult = method.invoke(targetVehicle, args);
                // System.out.println(invokeResult);
                System.out.println("交通工具停止运行了");
                return invokeResult;
            }
        };
        return (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
