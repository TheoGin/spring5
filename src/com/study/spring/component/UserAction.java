package com.study.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller(value = "userAction01")
public class UserAction {
    // @Autowired // 默认先按类型匹配，如果有多个bean，再按名称匹配
    // @Resource(name = "userService300")
    // @Resource(type = UserService.class)
    // @Resource // 默认先按名称匹配，如果名称匹配不到再按类型匹配
    @Autowired
    @Qualifier(value = "userService300") // 等价于 @Resource(name = "userService300")
    private UserService userService600;

    public void sayOk() {
        System.out.println("UserAction.userService= " + userService600);
        userService600.hi();
    }
}
