package com.iissy.springboot.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.lang.reflect.ParameterizedType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JPADaoBase<T> {
    private JdbcTemplate jdbcTemplate;
    private Class<T> clazz;

    @SuppressWarnings(value = "unchecked")
    public JPADaoBase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findOneById(Integer id) {
        String sql = "SELECT * FROM cuslink where id = ?";
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(clazz);
        log.debug("【执行SQL】SQL：{}", sql);
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);
    }
}