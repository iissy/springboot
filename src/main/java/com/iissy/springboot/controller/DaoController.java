package com.iissy.springboot.controller;

import java.util.List;

import com.iissy.springboot.common.ApiResponse;
import com.iissy.springboot.common.DataType;
import com.iissy.springboot.common.ParamType;
import com.iissy.springboot.jpa.LinkDao;
import com.iissy.springboot.model.UserLink;
import com.iissy.springboot.mybatis.UserLinkMapper;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/dao")
@Api(tags = "water", description = "用户管理", value = "用户管理")
public class DaoController {
    private final LinkDao dao;

    @Autowired
    private UserLinkMapper mapper;

    @Autowired
    public DaoController(LinkDao dao) {
        this.dao = dao;
    }

    @GetMapping("/jpa/{id}")
    @ApiOperation(value = "主键查询", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", dataType = DataType.INT, paramType = ParamType.PATH) })
    public ApiResponse<UserLink> get(@PathVariable Integer id) {
        log.info(id.toString());
        UserLink link = dao.queryForObject(id);
        return ApiResponse.<UserLink>builder().code(200).message("操作成功")
                .data(new UserLink(id, link.getTitle(), link.getUrl())).build();
    }

    @GetMapping("/mybatis/all")
    @ApiOperation(value = "获取所有数据", notes = "备注")
    public ApiResponse<List<UserLink>> index() {
        log.info("get all data");
        List<UserLink> list = mapper.selectAllUser();
        return ApiResponse.<List<UserLink>>builder().code(200).message("操作成功").data(list).build();
    }

    @GetMapping("/mybatis/{id}")
    @ApiOperation(value = "主键查询", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", dataType = DataType.INT, paramType = ParamType.PATH) })
    public ApiResponse<UserLink> get2(@PathVariable Integer id) {
        log.info(id.toString());
        UserLink link = mapper.selectUserById(id);
        return ApiResponse.<UserLink>builder().code(200).message("操作成功")
                .data(new UserLink(id, link.getTitle(), link.getUrl())).build();
    }
}