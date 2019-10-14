package com.iissy.springboot.jdbc;

import com.iissy.springboot.model.UserLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class LinkDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LinkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserLink queryForObject(Integer id) {
        String sql = "SELECT * FROM cuslink where id = ?";
        RowMapper<UserLink> rowMapper = new BeanPropertyRowMapper<>(UserLink.class);
        log.debug("【执行SQL】SQL：{}", sql);
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);
    }
}