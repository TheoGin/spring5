package com.study.spring.aop.proxy.pratice3_annotation_or_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class CalAspect_XML {

    public void before(JoinPoint joinPoint) {
        System.out.println("[XML]方法 " + joinPoint.getSignature().getName() + " 开始执行 " + System.currentTimeMillis());
    }

    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[XML]方法 " + joinPoint.getSignature().getName() + " 结束执行 " + System.currentTimeMillis() + " 返回值是 " + result);
    }

}
