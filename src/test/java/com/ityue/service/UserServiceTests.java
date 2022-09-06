package com.ityue.service;


import com.ityue.entity.User;
import com.ityue.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void insert(){
        try {
            User user = new User();
            user.setUsername("yue");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void login(){
        User yue = userService.login("yue", "123");
        System.out.println(yue);
    }

    @Test
    public void changePassword(){
        userService.changePassword(17,"admin","123","1234");
    }
//    @Test
//    public void select(){
//        User user = userMapper.findByUsername("ityue");
//        System.out.println(user);
//    }
    @Test
    public void getByUid(){
         System.err.println(userService.getByUid(17));
    }

    @Test
    public void changeInfo(){
        User user = new User();
        user.setEmail("123@123.com");
        user.setPhone("123124124");
        userService.changeInfo(17,"admin",user);
        System.err.println(12312312);
    }
    @Test
    public void updateAvatarByUid() {
        userService.updateAvatarByUid(17,"qweqwe","dadasdas");
    }
    @Test
    public void updateAvatarByUid1() {
        File file = new File("c:\\users\\program.JPG");
        String name = file.getName();
        System.out.println(name);
        int i = name.indexOf(".");
        System.out.println(i);
        String substring = name.substring(i);
        System.out.println(substring);
    }
}