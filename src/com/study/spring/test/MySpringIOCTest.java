package com.study.spring.test;

import com.study.spring.beans.Monster;
import org.dom4j.DocumentException;

import java.io.IOException;

public class MySpringIOCTest {
    public static void main(String[] args) throws DocumentException, IOException {
        MyApplicationContext ioc = new MyApplicationContext("src/beans.xml");

        Monster monster01 = (Monster) ioc.getBean("monster01");
        System.out.println(monster01);
    }
}
