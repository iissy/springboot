package com.iissy.springboot.controller;

import com.iissy.springboot.common.ApiResponse;
import com.iissy.springboot.common.DataType;
import com.iissy.springboot.common.ParamType;
import com.iissy.springboot.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/asy")
@Api(tags = "爱施员", description = "用户管理", value = "用户管理")
public class AsyController {

    @GetMapping("/{id}")
    @ApiOperation(value = "主键查询", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH) })
    public ApiResponse<User> get(@PathVariable Integer id) {
        log.info(id.toString());
        return ApiResponse.<User>builder().code(200).message("操作成功").data(new User(id, "u1", "p1")).build();
    }

}