package com.study.spring.jdbctemplate.dao;

import com.study.spring.beans.Monster;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MonsterDao {
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(Monster monster) {
        String sql = "insert into monster values (:monsterId, :name, :skill)";

        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(monster);
        namedParameterJdbcTemplate.update(sql, paramSource);
        System.out.println("saved monster: " + monster);
    }
}
