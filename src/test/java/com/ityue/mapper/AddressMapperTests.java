package com.ityue.mapper;


import com.ityue.entity.Address;
import com.ityue.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(1);
        addressMapper.insert(address);
    }

    @Test
    public void select(){
        Integer integer = addressMapper.countByUid(1);
        System.err.println(integer);
    }
}
