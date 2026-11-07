package com.study.spring.tx.pratice;

import com.study.spring.tx.pratice.dao.TaoBaoDao;
import com.study.spring.tx.pratice.service.TaoBaoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionText {
    @Test
    public void testTransferOut() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoDao bankDao = ioc.getBean(TaoBaoDao.class);
        bankDao.transferOut(1, 1);
        System.out.println("transfer out");
    }

    @Test
    public void testTransferIn() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoDao bankDao = ioc.getBean(TaoBaoDao.class);
        bankDao.transferIn(1, 1);
        System.out.println("transfer in");
    }

    @Test
    public void testQueryProductPrice() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoDao bankDao = ioc.getBean(TaoBaoDao.class);
        double price = bankDao.queryProductPrice(2);
        System.out.println("price: " + price);
    }

    @Test
    public void testUpdateProductStock() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoDao bankDao = ioc.getBean(TaoBaoDao.class);
        bankDao.updateProductStock(2, 1);
        System.out.println("update product stock");
    }

    @Test
    public void testQueryProductRate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoDao bankDao = ioc.getBean(TaoBaoDao.class);
        double rate = bankDao.queryProductRate(2);
        System.out.println("rate: " + rate);
    }

    @Test
    public void testquerySellerIdByProductId() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoDao bankDao = ioc.getBean(TaoBaoDao.class);
        int sellerId = bankDao.querySellerIdByProductId(2);
        System.out.println("sellerId: " + sellerId);
    }

    @Test
    public void testBuyProduct() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("tx_ioc.xml");
        TaoBaoService taoBaoService = ioc.getBean(TaoBaoService.class);
        taoBaoService.buyProduct(2, 2, 2);
        System.out.println("buy product");
    }
}
