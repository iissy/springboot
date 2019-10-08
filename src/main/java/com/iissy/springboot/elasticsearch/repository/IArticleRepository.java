package com.iissy.springboot.elasticsearch.repository;

import com.iissy.springboot.elasticsearch.document.*;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IArticleRepository extends ElasticsearchRepository<Article, String> {
}