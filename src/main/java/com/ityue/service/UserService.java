package com.ityue.service;

import com.ityue.entity.User;

public interface UserService {
    void reg(User user);

    User login(String username,String  password);

    void changePassword(Integer uid,String username,String oldPassword,String newPassword);
}
