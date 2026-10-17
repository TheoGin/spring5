package com.study.spring.controller;

import com.study.spring.service.OrderService;

public class OrderAction {
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
