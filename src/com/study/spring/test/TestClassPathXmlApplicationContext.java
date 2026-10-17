package com.study.spring.test;

import com.study.spring.beans.Monster;
import com.study.spring.component.MyComponent;
import com.study.spring.component.UserAction;
import com.study.spring.component.UserDao;
import com.study.spring.component.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClassPathXmlApplicationContext {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster01 = ioc.getBean("monster01", Monster.class);
        System.out.println(monster01);

    }

    @Test
    public void getBeanByAnnotation() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans02.xml");
        UserAction userAction = ioc.getBean(UserAction.class);
        System.out.println(userAction); // com.study.spring.component.UserAction@70be0a2b

        UserAction userAction01 = ioc.getBean("userAction01", UserAction.class);
        System.out.println(userAction01);

        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);

        MyComponent myComponent = ioc.getBean(MyComponent.class);
        System.out.println(myComponent);
    }
}
