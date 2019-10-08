package com.iissy.springboot.params;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "redis请求实体", description = "redis 处理的实体类")
public class RedisParam {
    private String key;
    private String value;
}