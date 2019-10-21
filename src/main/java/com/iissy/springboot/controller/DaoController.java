package com.iissy.springboot.controller;

import java.util.List;

import com.iissy.springboot.common.ApiResponse;
import com.iissy.springboot.common.DataType;
import com.iissy.springboot.common.ParamType;
import com.iissy.springboot.jdbc.CusLinkDao;
import com.iissy.springboot.model.CusLink;
import com.iissy.springboot.mybatis.CusLinkMapper;

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
@Api(tags = "dao", description = "网摘管理", value = "网摘管理")
public class DaoController {
    private final CusLinkDao dao;

    @Autowired
    private CusLinkMapper mapper;

    @Autowired
    public DaoController(CusLinkDao dao) {
        this.dao = dao;
    }

    @GetMapping("/jdbc/{id}")
    @ApiOperation(value = "主键查询", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", dataType = DataType.INT, paramType = ParamType.PATH) })
    public ApiResponse<CusLink> get(@PathVariable Integer id) {
        log.info(id.toString());
        CusLink link = dao.queryForObject(id);
        if (link == null) {
            return ApiResponse.<CusLink>builder().code(404).message("").data(null).build();
        } else {
            return ApiResponse.<CusLink>builder().code(200).message("操作成功")
                    .data(new CusLink(id, link.getTitle(), link.getUrl())).build();
        }
    }

    @GetMapping("/mybatis/all")
    @ApiOperation(value = "获取所有数据", notes = "备注")
    public ApiResponse<List<CusLink>> index() {
        log.info("get all data");
        List<CusLink> list = mapper.selectAllUser();
        return ApiResponse.<List<CusLink>>builder().code(200).message("操作成功").data(list).build();
    }

    @GetMapping("/mybatis/{id}")
    @ApiOperation(value = "主键查询", notes = "备注")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", dataType = DataType.INT, paramType = ParamType.PATH) })
    public ApiResponse<CusLink> get2(@PathVariable Integer id) {
        log.info(id.toString());
        CusLink link = mapper.selectCusLinkById(id);
        if (link == null) {
            return ApiResponse.<CusLink>builder().code(404).message("").data(null).build();
        } else {
            return ApiResponse.<CusLink>builder().code(200).message("操作成功")
                    .data(new CusLink(id, link.getTitle(), link.getUrl())).build();
        }
    }
}