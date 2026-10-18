package com.study.spring.aop.proxy.pratice2;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyAop {
    public static void before(Object proxy, Method method, Object[] args) {
        // System.out.println("方法执行开始-日志-方法名-" + method.getName() + "-参数[" + args[0] + ", " + args[1] + "]");
        System.out.println("方法执行开始-日志-方法名-" + method.getName() + "-参数" + Arrays.asList(args));
    }

    public static void after(Method method, Object invokeResult) {
        System.out.println("方法执行正常结束-日志-方法名-" + method.getName() + "-结果result= " + invokeResult);
    }
}
