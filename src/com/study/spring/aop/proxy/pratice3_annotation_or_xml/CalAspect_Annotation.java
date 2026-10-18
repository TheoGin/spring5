package com.study.spring.aop.proxy.pratice3_annotation_or_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Component
// @Aspect
public class CalAspect_Annotation {

    @Pointcut("execution(* com.study.spring.aop.proxy.pratice3_annotation_or_xml.Cal.*(..))")
    public void calPointcut() {}

    @Before("calPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("方法 " + joinPoint.getSignature().getName() + " 开始执行 " + System.currentTimeMillis());
    }

    @AfterReturning(value = "calPointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("方法 " + joinPoint.getSignature().getName() + " 结束执行 " + System.currentTimeMillis() + " 返回值是 " + result);
    }

}
