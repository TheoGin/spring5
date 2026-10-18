package com.study.spring.aop.proxy.pratice2;

public class SmartAnimalImpl implements SmartAnimal {
    @Override
    public Double getSum(Double num1, Double num2) {
        // System.out.println("日志-方法名-getSum-参数 " + num1 + " " + num2);

        double sum = num1 + num2;
        System.out.println("方法内部打印sum = " + sum);

        // System.out.println("日志-方法名-getSum-结果 sum = " + sum);
        return sum;
    }

    @Override
    public Double getSubtract(Double num1, Double num2) {
        // System.out.println("日志-方法名-getSubtract-参数 " + num1 + " " + num2);

        double subtract = num1 - num2;
        System.out.println("方法内部打印subtract = " + subtract);

        // System.out.println("日志-方法名-getSubtract-结果 subtract = " + subtract);
        return subtract;
    }
}
