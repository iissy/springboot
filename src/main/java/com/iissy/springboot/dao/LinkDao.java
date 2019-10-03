package com.iissy.springboot.dao;

import com.iissy.springboot.model.UserLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LinkDao extends JPADaoBase<UserLink> {
    @Autowired
    public LinkDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public UserLink selectById(Integer id) {
        return super.findOneById(id);
    }
}