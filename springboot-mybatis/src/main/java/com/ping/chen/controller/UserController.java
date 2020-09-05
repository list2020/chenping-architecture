package com.ping.chen.controller;

import com.ping.chen.entity.UserEntity;
import com.ping.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "list")
    public Object getUserList(){
        List<UserEntity> userList = userService.getUserList();
        return userList;
    }
}
