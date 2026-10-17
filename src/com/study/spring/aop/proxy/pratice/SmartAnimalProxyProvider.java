package com.study.spring.aop.proxy.pratice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SmartAnimalProxyProvider {
    private SmartAnimal targetSmartAnimal;

    public SmartAnimalProxyProvider(SmartAnimal smartAnimal) {
        this.targetSmartAnimal = smartAnimal;
    }

    public SmartAnimal getProxy() {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                System.out.println("方法执行开始-日志-方法名-" + method.getName() + "-参数[" + args[0] + ", " + args[1] + "]");
                Object invokeResult = null;
                try {
                    invokeResult = method.invoke(targetSmartAnimal, args);
                    System.out.println("方法执行正常结束-日志-方法名-" + method.getName() + "-结果result= " + invokeResult);
                } catch (IllegalAccessException e) {
                    System.out.println("方法执行异常结束-日志-方法名-" + method.getName() + "-异常信息-" + e.getMessage());
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    System.out.println("方法执行异常结束-日志-方法名-" + method.getName() + "-异常信息-" + e.getMessage());
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("方法最终结束-日志-方法名-" + method.getName());
                }
                return invokeResult;
            }
        };
        return (SmartAnimal) Proxy.newProxyInstance(
                targetSmartAnimal.getClass().getClassLoader(),
                targetSmartAnimal.getClass().getInterfaces(),
                invocationHandler
        );
    }
}
