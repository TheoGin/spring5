package com.study.spring.aop.proxy.aspectj.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_aspectj.xml");
        UsbInterface usbInterface = ioc.getBean(UsbInterface.class);
        usbInterface.work("手机");
    }
}
