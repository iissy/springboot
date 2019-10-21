package com.iissy.springboot.jdbc;

import com.iissy.springboot.model.CusLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CusLinkDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CusLinkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CusLink queryForObject(Integer id) {
        CusLink cuslink;
        String sql = "SELECT * FROM cuslink where id = ?";
        try {
            RowMapper<CusLink> rowMapper = new BeanPropertyRowMapper<>(CusLink.class);
            cuslink = jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);
            return cuslink;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}