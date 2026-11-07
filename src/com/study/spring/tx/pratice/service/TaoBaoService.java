package com.study.spring.tx.pratice.service;

import com.study.spring.tx.pratice.dao.TaoBaoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaoBaoService {
    @Autowired
    private TaoBaoDao taoBaoDao;

    @Transactional
    public void buyProduct(int userId, int num, int productId) {
        double price = taoBaoDao.queryProductPrice(productId);
        int sellerId = taoBaoDao.querySellerIdByProductId(productId);
        double rate = taoBaoDao.queryProductRate(productId);

        double money = price * num;
        taoBaoDao.transferOut(userId, money);

        taoBaoDao.updateProductStock(productId, num);

        double taobaoMoney = money * rate;
        taoBaoDao.transferIn(sellerId, money - taobaoMoney);

        taoBaoDao.updateTaobaoBalance(1, taobaoMoney);
    }

    /* private void transfer(int fromUserId, int toUserId, double money, double rate) {
        bankDao.transferOut(fromUserId, money);


        bankDao.transferIn(toUserId, money * (1 - rate));
    }

    public void buyProduct(int userId, int num, int productId) {
        double price = bankDao.queryProductPrice(productId);
        int sellerId = bankDao.querySellerIdByProductId(productId);
        double rate = bankDao.queryProductRate(productId);

        transfer(userId, sellerId, price * num, rate);
    } */
}
