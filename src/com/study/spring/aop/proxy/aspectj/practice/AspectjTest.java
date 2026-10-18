package com.study.spring.aop.proxy.aspectj.practice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjTest {
    @Test
    public void testInterfaceAspectj() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        // UsbInterface usbInterface = ioc.getBean(UsbInterface.class); // org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.study.spring.aop.proxy.aspectj.practice.UsbInterface' available: expected single matching bean but found 2: camera,phone
        UsbInterface phone = ioc.getBean("phone", UsbInterface.class);
        phone.work("手机");

        System.out.println("===================================");
        // UsbInterface camera = (Camera)ioc.getBean("camera"); // java.lang.ClassCastException: com.sun.proxy.$Proxy16 cannot be cast to com.study.spring.aop.proxy.aspectj.practice.Camera
        UsbInterface camera = ioc.getBean("camera", UsbInterface.class);
        camera.work("相机");
        System.out.println(camera.getClass()); // class com.sun.proxy.$Proxy16
    }

    @Test
    public void testClassAspectj() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        Car car = (Car)ioc.getBean("car");
        car.run();
        System.out.println(car.getClass()); // class com.study.spring.aop.proxy.aspectj.practice.Car$$EnhancerBySpringCGLIB$$489de324
    }

    @Test
    public void testAroundAspectj() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        UsbInterface phone = ioc.getBean("phone", UsbInterface.class);
        phone.work("手机");
    }

    @Test
    public void testPointcutAspectj2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        UsbInterface phone = ioc.getBean("phone", UsbInterface.class);
        phone.work("手机");
    }

    @Test
    public void testOrderAspectj3() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        UsbInterface phone = ioc.getBean("phone", UsbInterface.class);
        phone.work("手机");
    }
}
