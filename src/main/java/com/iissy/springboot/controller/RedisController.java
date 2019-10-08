package com.iissy.springboot.controller;

import com.iissy.springboot.common.DataType;
import com.iissy.springboot.common.ParamType;
import com.iissy.springboot.params.RedisParam;
import com.iissy.springboot.redis.RedisClient;

import com.iissy.springboot.common.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/redis")
@Api(tags = "water", description = "用户管理", value = "用户管理")
public class RedisController {
    @Autowired
    private RedisClient client;

    @GetMapping("/get/{key}")
    @ApiOperation(value = "key search", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "redis key", dataType = DataType.STRING, paramType = ParamType.PATH) })
    public ApiResponse<String> get(@PathVariable String key) {
        log.info(key.toString());
        String value = client.get(key).toString();
        return ApiResponse.<String>builder().code(200).message("操作成功")
        .data(value).build();
    }

    @PostMapping("/set")
    @ApiOperation(value = "保存值", notes = "备注")
    public ApiResponse<Boolean> set(@RequestBody RedisParam param) {
        String key = param.getKey();
        String value = param.getValue();
        log.info(String.format("%s, %s", key, value));
        Boolean result = client.set(key, value);
        return ApiResponse.<Boolean>builder().code(200).message("操作成功")
        .data(result).build();
    }
}