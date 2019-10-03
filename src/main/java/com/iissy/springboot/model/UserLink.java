package com.iissy.springboot.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体", description = "UserLink Entity")
public class UserLink implements Serializable {
    private static final long serialVersionUID = 5057954049311281252L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", example = "0", required = true)
    private Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    /**
     * 工作岗位
     */
    @ApiModelProperty(value = "地址", required = true)
    private String url;
}