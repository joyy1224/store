package com.ityue.service;


import com.ityue.entity.User;
import com.ityue.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}