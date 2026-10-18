package com.study.spring.aop.proxy.aspectj.practice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// @Aspect
// @Component
public class SmartAnimalAspect2_Around {

    @Around(value = "execution(public String com.study.spring.aop.proxy.aspectj.practice.Phone.work(String))")
    public void doAround(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String signatureName = signature.getName();
        List<Object> argsList = Arrays.asList(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("A0P环绕通知--" + signatureName + "方法开始了--参数有：" + argsList);
            result = joinPoint.proceed();
            System.out.println("AoP环绕通知" + signatureName + "方法结束了--结果是：" + result);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("AoP后置通知" + signatureName + "方法最终结束了...");
        }
    }
}
