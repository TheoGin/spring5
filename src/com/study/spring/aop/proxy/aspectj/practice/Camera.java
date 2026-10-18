package com.study.spring.aop.proxy.aspectj.practice;

import org.springframework.stereotype.Component;

@Component
public class Camera implements UsbInterface {
    @Override
    public String work(String deviceName) {
        String status = "Using " + deviceName + " to work";
        System.out.println("Camera 类的 work方法内部：" + status);
        return status;
    }
}
