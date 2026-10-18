package com.study.spring.aop.proxy.pratice3_annotation_or_xml;

import org.springframework.stereotype.Component;

// @Component
public class MyCal implements Cal {
    @Override
    public int cal1(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("cal1 sum=" + sum);
        return sum;
    }

    @Override
    public int cal2(int n) {
        int accMultiple = 1;
        for (int i = 1; i <= n; i++) {
            accMultiple *= i;
        }
        System.out.println("cal2 accMultiple=" + accMultiple);
        return accMultiple;
    }
}
