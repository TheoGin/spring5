package com.study.spring.aop.proxy.aspectj.practice;

import org.springframework.stereotype.Component;

@Component
public class Phone implements UsbInterface {
    @Override
    public String work(String deviceName) {
        String status = "Using " + deviceName + " to work";
        // int divide = 8 / 0;
        System.out.println("Phone 类的 work方法内部：" + status);
        return status;
    }
}
