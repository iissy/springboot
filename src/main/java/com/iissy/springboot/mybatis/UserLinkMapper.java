package com.iissy.springboot.mybatis;

import com.iissy.springboot.model.UserLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserLinkMapper {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("SELECT * FROM cuslink")
    List<UserLink> selectAllUser();

    /**
     * 根据id查询用户
     *
     * @param id 主键id
     * @return 当前id的用户，不存在则是 {@code null}
     */
    UserLink selectUserById(@Param("id") Integer id);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int saveUser(@Param("userlink") UserLink user);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int deleteById(@Param("id") Integer id);

}