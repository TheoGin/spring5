package com.study.spring.aop.proxy.pratice3_annotation_or_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalAspectTest {
    @Test
    public void testAspectAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_AspectAnnotation.xml");
        Cal cal = ioc.getBean( Cal.class);// 获取bean
        cal.cal1(3);

        System.out.println("---------------------");
        cal.cal2(3);
    }

    @Test
    public void testAspectXML() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans_praticeAspectXML.xml");
        Cal cal = ioc.getBean(Cal.class);// 获取bean
        cal.cal1(3);

        System.out.println("---------------------");
        cal.cal2(3);
    }
}
