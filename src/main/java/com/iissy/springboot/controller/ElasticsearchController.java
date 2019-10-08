package com.iissy.springboot.controller;

import com.iissy.springboot.common.ApiResponse;
import com.iissy.springboot.elasticsearch.document.Article;
import com.iissy.springboot.elasticsearch.repository.IArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/elasticsearch")
@Api(tags = "water", description = "elasticsearch", value = "elasticsearch")
public class ElasticsearchController {
    @Autowired
    private IArticleRepository articleRepository;

    @PostMapping("/save")
    @ApiOperation(value = "索引文档", notes = "备注")
    public ApiResponse<Article> get(@RequestBody Article article) {
        log.info(article.toString());
        Article result = articleRepository.save(article);
        return ApiResponse.<Article>builder().code(200).message("操作成功")
        .data(result).build();
    }
}