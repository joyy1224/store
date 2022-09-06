package com.ityue.controller;


import com.ityue.common.BaseException;
import com.ityue.entity.User;
import com.ityue.service.UserService;
import com.ityue.service.ex.InsertException;
import com.ityue.service.ex.UsernameDuplicatedException;
import com.ityue.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.ityue.common.BaseException.OK;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController{


    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK,"注册成功！");
    }

//    @PostMapping("/login")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult<User> login(String username, String password,HttpSession session){
        User login = userService.login(username, password);
        session.setAttribute("username",login.getUsername());
        session.setAttribute("uid",login.getUid());
        System.out.println(getUidFromSession(session) + getUserFromSession(session));
        return new JsonResult<User>(OK,login);
    }

    @PostMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uidFromSession = getUidFromSession(session);
        String userFromSession = getUserFromSession(session);
        userService.changePassword(uidFromSession,userFromSession,oldPassword,newPassword);
        session.removeAttribute("uid");
        return new JsonResult<>(OK);
    }


    @PostMapping("/get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
        User user = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK,user);
    }

    @GetMapping("/change_Info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        userService.changeInfo(getUidFromSession(session),getUserFromSession(session),user);
        return new JsonResult<>(OK);
    }

    protected final Integer getUidFromSession(HttpSession httpSession){
        Integer uid = Integer.valueOf(httpSession.getAttribute("uid").toString());
        return uid;
    }

    protected final String getUserFromSession(HttpSession httpSession) {
        return httpSession.getAttribute("username").toString();
    }
}
