package com.sky.hrpro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: CarryJey
 * @Date: 2018/10/11 11:00:50
 */

/**
 * Id 生成器
 * dual表是mysql和oracal的虚拟表，可利用生成id
 * 如需生成随机码，可使用当前时间生成随机码+这个id。
 */
@Repository
public class IdDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Long> nextId(int  acount){
        return jdbcTemplate.queryForList("SELECT id.nextVal FROM dual WHRER count = ?",new Object[] {acount},Long.class);
    }

    public long nextId(){
        return nextId(1).get(0);
    }
}
