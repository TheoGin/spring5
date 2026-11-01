package com.study.spring.tx.service;

import com.study.spring.tx.dao.GoodsDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyGoods(int userId, int goodsId, int num) {
        double price = goodsDao.queryPriceById(goodsId);
        goodsDao.updateBalance(userId, price * num);
        goodsDao.updateGoodsNum(goodsId, num);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyGoods2(int userId, int goodsId, int num) {
        double price = goodsDao.queryPriceById2(goodsId);
        goodsDao.updateBalance2(userId, price * num);
        goodsDao.updateGoodsNum2(goodsId, num);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void buyGoodsByTxISOLATION(int userId, int goodsId, int num) {
        double price = goodsDao.queryPriceById(goodsId);
        System.out.println("第一次读取的价格= " + price);

        price = goodsDao.queryPriceById(goodsId);
        System.out.println("第二次读取的价格= " + price);
    }
}
