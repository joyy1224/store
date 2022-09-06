package com.ityue.mapper;


import com.ityue.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("ityue");
        user.setPassword("123");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void select(){
        User user = userMapper.findByUsername("ityue");
        System.out.println(user);
    }

    @Test
    public void selectByuid(){
        User byUid = userMapper.findByUid(14);
        System.out.println(byUid);
    }

    @Test
    public void updatebyuid(){
        userMapper.updatePasswordByUid(14,"1234","admin",new Date());
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(17);
        user.setEmail("999919@168.com");
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(17,"123","管理员",new Date());
    }
}
