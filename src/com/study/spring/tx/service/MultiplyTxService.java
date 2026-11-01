package com.study.spring.tx.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class MultiplyTxService {
    @Resource
    private GoodsService goodsService;

    @Transactional
    public void multiplyTx() {
        goodsService.buyGoods(1, 1, 1);
        goodsService.buyGoods2(1, 1, 1);
    }
}
