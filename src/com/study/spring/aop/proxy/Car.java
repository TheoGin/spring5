package com.study.spring.aop.proxy;

public class Car implements Vehicle {
    @Override
    public void run() {
        // System.out.println("交通工具开始运行了");
        System.out.println("小汽车在公路   running..");
        // System.out.println("交通工具停止运行了");
    }

    @Override
    public String fly(int height) {
        return "飞行汽车，飞行高度：" + height;
    }

}
