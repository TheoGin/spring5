package com.study.spring.aop.proxy.aspectj.practice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class SmartAnimalAspect {
    @Before("execution(public String com.study.spring.aop.proxy.aspectj.practice.Phone.work(String))")
    public void showBeginLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类的前置通知，执行前 showBeginLog 方法执行 " + signature.getName() + " 参数是 " + Arrays.asList(joinPoint.getArgs()));
    }
}
