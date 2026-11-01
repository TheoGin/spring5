package com.study.spring.tx;

import com.study.spring.tx.dao.GoodsDao;
import com.study.spring.tx.service.GoodsService;
import com.study.spring.tx.service.MultiplyTxService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {
    @Test
    public void queryPriceByIdTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");

        GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
        double price = goodsDao.queryPriceById(1);
        System.out.println("商品价格为：" + price);
    }


    @Test
    public void updateBalanceTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");

        GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
        goodsDao.updateBalance(1, 1800);
    }

    @Test
    public void updateGoodsNumTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsDao goodsDao = ioc.getBean(GoodsDao.class);
        goodsDao.updateGoodsNum(1, 1);
    }

    @Test
    public void buyGoodsTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        GoodsService goodsService = ioc.getBean(GoodsService.class);
        goodsService.buyGoods(1, 1, 1);
    }

    @Test
    public void buyGoodsByMulTxTest() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        MultiplyTxService multiplyTxService = ioc.getBean(MultiplyTxService.class);
        multiplyTxService.multiplyTx();
    }

}
