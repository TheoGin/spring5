package com.study.spring.tx.service;

import com.study.spring.tx.dao.GoodsDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Transactional
    public void buyGoods(int userId, int goodsId, int num) {
        double price = goodsDao.queryPriceById(goodsId);
        goodsDao.updateBalance(userId, price * num);
        goodsDao.updateGoodsNum(goodsId, num);
    }
}
