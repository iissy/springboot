package com.iissy.springboot.elasticsearch.document;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "elasticsearch请求实体", description = "elasticsearch 处理的实体类")
@Document(indexName = "asy", type = "article")
public class Article implements Serializable {
    private static final long serialVersionUID = 804354423280231L;

    private String id;
    private String title;
}