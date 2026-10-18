package com.study.spring.aop.proxy.aspectj.practice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class SmartAnimalAspect3_Pointcut {
    @Pointcut("execution(public String com.study.spring.aop.proxy.aspectj.practice.Phone.work(String))")
    public void myPointcut() {
    }

    @Before("execution(public String Phone.work(String)) || execution(public void com.study.spring.aop.proxy.aspectj.practice.Car.run())")
    public void showBeginLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类的，执行前 showBeginLog 方法执行 " + signature.getName() + " 参数是 " + Arrays.asList(joinPoint.getArgs()));
    }

    // @AfterReturning("execution(public String Phone.work(String)) || execution(public String Camera.work(String))")
    // @AfterReturning(value = "execution(public String UsbInterface.work(String))", returning = "result") // 上下等价
    @AfterReturning(value = "myPointcut()", returning = "result") // 上下等价
    public void showSuccessEndLog(JoinPoint joinPoint, String result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[Pointcut]切面类的，执行后 showSuccessEndLog 方法执行 " + signature.getName() + " 参数是 " + Arrays.asList(joinPoint.getArgs()) + " 返回值是 " + result);
    }

    @AfterThrowing(value = "execution(public String com.study.spring.aop.proxy.aspectj.practice.Phone.work(String))", throwing = "throwing")
    public void showExceptionLog(JoinPoint joinPoint, Throwable throwing) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类的，执行后 showExceptionLog 方法执行 " + signature.getName() + " 异常是 " + throwing);
    }

    @After("execution(public String com.study.spring.aop.proxy.aspectj.practice.*.work(String)) || execution(public void Car.run())")
    public void showFinallyEndLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("切面类的，执行后 showFinallyEndLog 方法执行 " + signature.getName());

        // System.out.println("signature.getDeclaringTypeName(): " + signature.getDeclaringTypeName()); // 输出类名
        // System.out.println("signature.getDeclaringType(): " + signature.getDeclaringType().getSimpleName()); // 输出简单类名
        // // System.out.println("signature.getDeclaringType(): " + signature.getDeclaringType()); // 输出类类型
        // System.out.println("signature.getModifiers(): " + signature.getModifiers()); // 输出修饰符
        // System.out.println("joinPoint.getTarget(): " + joinPoint.getTarget());
        // System.out.println("joinPoint.getThis(): " + joinPoint.getThis());
    }

}
