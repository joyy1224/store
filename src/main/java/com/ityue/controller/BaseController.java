package com.ityue.controller;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class BaseController {

    public static final int AVATAR_MAX_SIZE = 10 *1024 *1024;

    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    protected static final Integer getUidFromSession(HttpSession httpSession){
        Integer uid = Integer.valueOf(httpSession.getAttribute("uid").toString());
        return uid;
    }

    protected static final String getUserFromSession(HttpSession httpSession) {
        return httpSession.getAttribute("username").toString();
    }
}
