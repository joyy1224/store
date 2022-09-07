package com.ityue.service.serviceImpl;

import com.ityue.entity.Address;
import com.ityue.mapper.AddressMapper;
import com.ityue.service.AddressService;
import com.ityue.service.ex.AddressCountLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author ASUS
* @description 针对表【t_address】的数据库操作Service实现
* @createDate 2022-09-07 10:39:19
*/
@Service
public class AddressServiceImpl implements  AddressService{

    @Autowired
    private AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private Integer count;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if (count > 20){
            throw new AddressCountLimitException("地址数量上限！");
        }else{
            Integer isdef = count == 0? 1 : 0;
            address.setIsDefault(isdef);
        }
        address.setUid(uid);

        Date date = new Date();
        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(date);
        address.setModifiedTime(date);
        addressMapper.insert(address);
    }
}
