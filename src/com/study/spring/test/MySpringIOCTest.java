package com.study.spring.test;

import org.dom4j.DocumentException;

import java.io.IOException;

public class MySpringIOCTest {
    public static void main(String[] args) throws DocumentException, IOException {
        MyApplicationContext ioc = new MyApplicationContext("beans.xml");

    }
}
