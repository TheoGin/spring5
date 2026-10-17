package com.study.spring.test;

import com.study.spring.beans.Monster;
import com.study.spring.beans.SpringExpressionLanguageBean;
import com.study.spring.component.UserAction;
import com.study.spring.component.UserService;
import com.study.spring.controller.OrderAction;
import com.study.spring.depinjection.BookService;
import com.study.spring.depinjection.PhoneService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5BeanTest {
    @Test
    public void testPropertiesFile() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_properties_file.xml");
        Monster monster100 = ioc.getBean("monster100", Monster.class);
        System.out.println(monster100);
    }

    @Test
    public void getBeanByGenericDepInjection() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_DI.xml");
        BookService bookService = ioc.getBean(BookService.class);
        bookService.save();

        PhoneService phoneService = ioc.getBean(PhoneService.class);
        phoneService.save();
    }


    @Test
    public void getBeanByXMLAutowire() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_autowire.xml");
        OrderAction orderAction = ioc.getBean("orderAction", OrderAction.class);
        orderAction.getOrderService().getOrderDao().saveOrder();
    }

    @Test
    public void getBeanByAnnotationAutowire() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans02.xml");
        System.out.println("ioc userService: " + ioc.getBean("userService", UserService.class));
        System.out.println("ioc userService200: " + ioc.getBean("userService200", UserService.class));
        System.out.println("ioc userService300: " + ioc.getBean("userService300", UserService.class));
        UserAction userAction = ioc.getBean("userAction01", UserAction.class);
        userAction.sayOk();
    }

    @Test
    public void testSpringExpressionLanguageBean() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans_el.xml");
        SpringExpressionLanguageBean springExpressionLanguageBean = ioc.getBean("springExpressionLanguageBean", SpringExpressionLanguageBean.class);
        System.out.println(springExpressionLanguageBean);
    }
}
