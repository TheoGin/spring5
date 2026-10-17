package com.study.spring.service;

import com.study.spring.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao02(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
