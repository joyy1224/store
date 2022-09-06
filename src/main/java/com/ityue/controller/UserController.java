package com.ityue.controller;


import com.ityue.common.BaseException;
import com.ityue.controller.ex.*;
import com.ityue.entity.User;
import com.ityue.service.UserService;
import com.ityue.service.ex.InsertException;
import com.ityue.service.ex.UsernameDuplicatedException;
import com.ityue.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.ityue.common.BaseException.OK;

//@Controller
@Slf4j
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

    @PostMapping("/change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空！");
        }
        if(file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("文件过大");
        }
        String contentType = file.getContentType();
        log.info("文件类型{}",contentType);
//        包含返回true
        if (!AVATAR_TYPE.contains(contentType)){
            throw new FiletypeException("文件类型错误");
        }
        String realPath = session.getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        String originalFilename = file.getOriginalFilename();
        //123.jpg
        int indexOf = originalFilename.indexOf(".");
        String substring = originalFilename.substring(indexOf);
        String filename = UUID.randomUUID().toString().toUpperCase() + substring;
        File dest = new File(dir,filename);
        log.info("路径{}",dest.getPath());
        try {
            file.transferTo(dest);
        }catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUserFromSession(session);
        String avatar = "/upload/"+filename;
        userService.updateAvatarByUid(uid,avatar,username);
        return new JsonResult<>(OK,avatar);
    }

    public static final int AVATAR_MAX_SIZE = 10 *1024 *1024;

    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    protected final Integer getUidFromSession(HttpSession httpSession){
        Integer uid = Integer.valueOf(httpSession.getAttribute("uid").toString());
        return uid;
    }

    protected final String getUserFromSession(HttpSession httpSession) {
        return httpSession.getAttribute("username").toString();
    }
}
