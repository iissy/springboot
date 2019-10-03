package com.iissy.springboot.jpa;

import com.iissy.springboot.model.UserLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LinkDao extends DaoBase<UserLink> {
    @Autowired
    public LinkDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }
}