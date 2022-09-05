package com.ityue.service.serviceImpl;

import com.ityue.entity.User;
import com.ityue.mapper.UserMapper;
import com.ityue.service.UserService;
import com.ityue.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
//        if (user == null){
//            return;
//        }
        user.setUsername(user.getUsername().replace(" ",""));
        User username = userMapper.findByUsername(user.getUsername());
        if (username != null){
            throw new UsernameDuplicatedException("用户名被占用！");
        }

        String password = user.getPassword();
        String toUpperCase = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMD5Password(password, toUpperCase);
        user.setSalt(toUpperCase);
        user.setPassword(md5Password);
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows != 1){
            throw new InsertException("在注册时出现未知的异常！");
        }
    }

    @Override
    public User login(String username, String password) {

        User byUsername = userMapper.findByUsername(username);
        if (byUsername == null){
            throw new UserNotException("用户还未注册！");
        }

        String salt = byUsername.getSalt();
        String password1 = byUsername.getPassword();
        String md5Password = getMD5Password(password, salt);
        if (!Objects.equals(password1,md5Password))
        throw new PasswordNotMatchException("用户名或密码输入错误");

        if (byUsername.getIsDelete() == 1){
            throw new UserNotException("用户数据不存在！");
        }

        User user = new User();
        user.setUid(byUsername.getUid());
        user.setUsername(byUsername.getUsername());
        user.setAvatar(byUsername.getAvatar());
        return user;
    }

    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User byUid = userMapper.findByUid(uid);
        if (byUid == null || byUid.getIsDelete() == 1){
            throw new UserNotException("用户数据不存在");
        }
        String md5Password = getMD5Password(oldPassword, byUid.getSalt());
        if(!Objects.equals(byUid.getPassword(),md5Password)){
            throw new PasswordNotMatchException("密码错误");
        }
        String md5Password1 = getMD5Password(newPassword, byUid.getSalt());
        Integer integer = userMapper.updatePasswordByUid(uid, md5Password1, username, new Date());
        if (integer != 1){
            throw new UpdateException("更新时发生未知异常");
        }
    }

    private String getMD5Password(String password, String salt){
        for (int i = 1;i < 3; i++){
             password = DigestUtils.md5DigestAsHex((salt+password).getBytes()).toUpperCase();
        }
        return password;
    }
}
