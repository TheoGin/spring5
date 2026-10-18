package com.study.spring.aop.proxy.aspectj.practice;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public void run() {
        System.out.println("Car is running");
    }
}
