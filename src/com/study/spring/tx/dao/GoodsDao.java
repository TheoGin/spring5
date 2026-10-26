package com.study.spring.tx.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GoodsDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public double queryPriceById(int id) {
        String sql = "select price from goods where goods_id = ?";
        // double price = jdbcTemplate.queryForObject(sql, new Object[]{goodsId}, Double.class);
        double price = jdbcTemplate.queryForObject(sql, Double.class, id);
        // System.out.println("商品价格为：" + price);
        return price;
    }

    public void updateBalance(int userId, double money) {
        String sql = "update user_account set money = money - ? where user_id = ?";
        jdbcTemplate.update(sql, money, userId);
    }

    public void updateGoodsNum(int goodsId, int num) {
        String sql = "update goods_amount set goods_num = goods_num - ? where goods_id = ?";
        jdbcTemplate.update(sql, num, goodsId);
    }
}
