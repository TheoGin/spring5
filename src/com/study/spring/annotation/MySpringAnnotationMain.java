package com.study.spring.annotation;

import com.study.spring.component.MyComponent;
import com.study.spring.component.UserAction;
import com.study.spring.component.UserDao;
import com.study.spring.component.UserService;

public class MySpringAnnotationMain {
    public static void main(String[] args) {
        MySpringApplicationContext mySpringApplicationContext = new MySpringApplicationContext(MySpringConfig.class);

        UserAction userAction = (UserAction) mySpringApplicationContext.getBean("userAction01");
        System.out.println(userAction);

        UserService userService = (UserService) mySpringApplicationContext.getBean("userService");
        System.out.println(userService);

        UserDao userDao = (UserDao) mySpringApplicationContext.getBean("userDao");
        System.out.println(userDao);

        MyComponent myComponent = (MyComponent) mySpringApplicationContext.getBean("myComponent");
        System.out.println(myComponent);
    }
}
