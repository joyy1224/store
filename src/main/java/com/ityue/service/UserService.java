package com.ityue.service;

import com.ityue.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserService {
    void reg(User user);

    User login(String username,String  password);

    void changePassword(Integer uid,String username,String oldPassword,String newPassword);

    User getByUid(Integer uid);

    void changeInfo(Integer uid,String username,User user);

    void updateAvatarByUid(Integer uid, String avatar,
                              String modifiedUser);
}
