package com.ityue.mapper;


import com.ityue.entity.Address;

/**
* @author ASUS
* @description 针对表【t_address】的数据库操作Mapper
* @createDate 2022-09-07 10:39:19
* @Entity com.ityue.entity.Address
*/
public interface AddressMapper {

    Integer insert(Address address);

    Integer countByUid(Integer uid);
}
