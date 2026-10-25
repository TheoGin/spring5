package com.study.spring.jdbctemplate;

import com.study.spring.beans.Monster;
import com.study.spring.jdbctemplate.dao.MonsterDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JdbcTemplateTest {

    @Test
    public void testDataSourceByJdbcTemplate() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        // ioc.getBean("dataSource");
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

    /*
    * -- 创建表monster
        CREATE TABLE monster(
        id INT PRIMARY KEY,
        name VARCHAR(64) NOT NULL DEFAULT '',
        skill VARCHAR(64) NOT NULL DEFAULT ''
        )CHARSET=utf8;
        INSERT INTO monster VALUES(100, '青牛怪', '吐火');
        INSERT INTO monster VALUES(200, '黄袍怪', '吐烟');
        INSERT INTO monster VALUES(300, '蜘蛛怪', '吐丝');
    *  */
    @Test
    public void addDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        /* String sql = "insert into monster values (400, '老鼠精', '挖坑')";
        jdbcTemplate.execute(sql); */

        String sql = "insert into monster values (?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, 500, "小王", "挖坑");
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void updateDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        String sql = "update monster set name = ? where id = ?";
        int affectedRows = jdbcTemplate.update(sql, "蛇精", 500);
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void addBatchDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "insert into monster values (?, ?, ?)";
        ArrayList<Object[]> list = new ArrayList<>();
        list.add(new Object[]{600, "白蛇精", "吃人"});
        list.add(new Object[]{700, "青蛇精", "吃小孩"});
        int[] affectedRows = jdbcTemplate.batchUpdate(sql, list);
        for (int affectedRow : affectedRows) {
            System.out.println("affectedRow = " + affectedRow);
        }
        System.out.println("batchUpdate ok");
    }

    @Test
    public void queryDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "select id, name, skill from monster where id = ?";
        BeanPropertyRowMapper<Monster> monsterBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, monsterBeanPropertyRowMapper, 700);
        System.out.println(monster);
    }

    @Test
    public void selectMulDataByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        // String sql = "select id, name, skill from monster where id >= ?";
        String sql = "select id as monsterId, name, skill from monster where id >= ?";
        BeanPropertyRowMapper<Monster> monsterBeanPropertyRowMapper = new BeanPropertyRowMapper<>(Monster.class);
        List<Monster> monsters = jdbcTemplate.query(sql, monsterBeanPropertyRowMapper, 200);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

    @Test
    public void selectScalarByJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "select count(*) from monster";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("count = " + count);
    }

    @Test
    public void testDataByNamedParameterJdbcTemplate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        NamedParameterJdbcTemplate jdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

        String sql = "insert into monster values (:my_id, :name, :skill)";
        HashMap<String, Object> map_parameter = new HashMap<String, Object>();
        map_parameter.put("my_id", 800);
        map_parameter.put("name", "螃蟹精");
        map_parameter.put("skill", "钳子无敌大法");

        int affectedRows = jdbcTemplate.update(sql, map_parameter);
        System.out.println("affectedRows = " + affectedRows);

        System.out.println("testDataByNamedParameterJdbcTemplate ok");
    }

    @Test
    public void operDataBySqlparametersoruce() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

        String sql = "insert into monster values (:monsterId, :name, :skill)";

        Monster monster = new Monster(900, "狐狸精", "狐媚之术");
        BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(monster);
        namedParameterJdbcTemplate.update(sql, beanPropertySqlParameterSource);

        System.out.println("operDataBySqlparametersoruce ok");
    }

    @Test
    public void operDataByDao() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("JdbcTemplate_ioc.xml");
        MonsterDao monsterDao = ioc.getBean(MonsterDao.class);
        Monster monster = new Monster(1000, "猴子精", "猴子的技能");
        monsterDao.save(monster);
        System.out.println("operDataByDao ok");
    }
}
