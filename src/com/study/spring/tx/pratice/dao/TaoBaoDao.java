package com.study.spring.tx.pratice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaoBaoDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void transferOut(int fromUserId, double money) {
        String sql = "update buyer set balance = balance - ? where id = ?";
        jdbcTemplate.update(sql, money, fromUserId);
    }

    public void transferIn(int toUserId, double money) {
        String sql = "update seller set balance = balance + ? where id = ?";
        jdbcTemplate.update(sql, money, toUserId);
    }

    public double queryProductPrice(int productId) {
        String sql = "select price from product where id = ?";
        Double price = jdbcTemplate.queryForObject(sql, Double.class, productId);
        return price;
    }

    public double queryProductRate(int productId) {
        String sql = "select rate from taobao where id = ?";
        Double rate = jdbcTemplate.queryForObject(sql, Double.class, productId);
        return rate;
    }

    public int querySellerIdByProductId(int productId) {
        String sql = "select seller_id from product where id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, productId);
    }

    public void updateProductStock(int productId, int stockNum) {
        String sql = "update product set stock = stock - ? where id = ?";
        jdbcTemplate.update(sql, stockNum, productId);
    }

    public void updateTaobaoBalance(int taoBaoId, double balance) {
        String sql = "update taoBao set balance = balance + ? where id = ?";
        jdbcTemplate.update(sql, balance, taoBaoId);
    }
}
