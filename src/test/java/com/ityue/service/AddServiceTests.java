package com.ityue.service;


import com.ityue.entity.Address;
import com.ityue.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddServiceTests {

    @Autowired
    private AddressService addressService;

    @Test
    public void insert() {
        Address address = new Address();
        address.setName("张三");
        addressService.addNewAddress(12,"admin",address);
    }
}