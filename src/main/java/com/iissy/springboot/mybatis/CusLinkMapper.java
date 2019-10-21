package com.iissy.springboot.mybatis;

import java.util.List;

import com.iissy.springboot.model.CusLink;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CusLinkMapper {

    /**
     * 查询所有网摘
     *
     * @return 网摘列表
     */
    @Select("SELECT * FROM cuslink")
    List<CusLink> selectAllUser();

    /**
     * 根据id查询网摘
     *
     * @param id 主键id
     * @return 当前id的网摘，不存在则是 {@code null}
     */
    CusLink selectCusLinkById(@Param("id") Integer id);

    /**
     * 保存网摘
     *
     * @param user 网摘
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int saveUser(@Param("cuslink") CusLink cuslink);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int deleteById(@Param("id") Integer id);
}