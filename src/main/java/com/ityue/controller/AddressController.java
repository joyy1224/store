package com.ityue.controller;

import com.ityue.entity.Address;
import com.ityue.service.AddressService;
import com.ityue.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


import static com.ityue.common.BaseException.OK;

//@AddressController
@Slf4j
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController{

    @Autowired
    private AddressService addressService;

    @PostMapping("/addnew")
//    @RequestMapping("/add_new_address")
    public JsonResult<Void> addNewAddresses(Address address,HttpSession session){
        Integer uid = getUidFromSession(session);
        String user = getUserFromSession(session);
        addressService.addNewAddress(uid,user,address);
        return new JsonResult<>(OK);
    }
}
