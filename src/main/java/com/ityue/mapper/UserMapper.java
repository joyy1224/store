package com.ityue.mapper;

import com.ityue.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

//@Mapper
public interface UserMapper {

    /**
     * 插入用户数据（注册）
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     *根据uid修改密码
     * @return
     */
    Integer updatePasswordByUid(@Param("uid") Integer uid,@Param("password") String password,
                                @Param("modifiedUser")String modifiedUser, @Param("modifiedTime")Date modifiedTime);
    /**
     * 跟进uid查询是否存在
     * @param uid
     * @return
     */
    User findByUid(Integer uid);

    /**
     * 根据uid 查询
     * @param uid
     * @return
     */
    Integer updateInfoByUid(User user);
}
