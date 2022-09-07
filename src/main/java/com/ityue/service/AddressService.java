package com.ityue.service;


import com.ityue.entity.Address;

/**
* @author ASUS
* @description 针对表【t_address】的数据库操作Service
* @createDate 2022-09-07 10:39:19
*/
public interface AddressService{
    void addNewAddress(Integer uid, String username , Address address);
}
