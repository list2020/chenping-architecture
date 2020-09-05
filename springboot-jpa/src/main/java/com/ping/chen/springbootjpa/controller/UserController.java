package com.ping.chen.springbootjpa.controller;

import com.ping.chen.springbootjpa.entity.UserEntity;
import com.ping.chen.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 跳转登录界面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "/login";
    }


    /**
     * 登录验证
     * @return
     */
    @RequestMapping("login")
    public ModelAndView login(UserEntity user){
        String login = userService.login(user);
        if("0".equals(login)){
            return new ModelAndView("redirect:/user/list");
        }else if("2".equals(login)){
            return new ModelAndView("redirect:/user/register");
        }
        return new ModelAndView("redirect:/user/index");
    }

    /**
     * 查询列表
     * @param modelMap
     * @return
     */
    @RequestMapping("list")
    public String getUsers(ModelMap modelMap){
        List<UserEntity> list = userService.queryUsers();
        modelMap.put("users", list);
        return "/list";
    }

    /**
     * 跳转到添加用户的界面
     * @return
     */
    @RequestMapping("add")
    public String addUser(){
        return "add";
    }

    /**
     * 用户注册
     * @return
     */
    @RequestMapping("register")
    public String registerUser(){
        return "register";
    }


    /**
     * 保存
     * @param request
     * @param userEntity
     * @return
     */
    @RequestMapping("save")
    public ModelAndView saveUser(HttpServletRequest request, UserEntity userEntity){
        userService.saveUser(userEntity);
        return new ModelAndView("redirect:/user/list");
    }

    /**
     * 保存
     * @param request
     * @param userEntity
     * @return
     */
    @RequestMapping("updateUser")
    public ModelAndView updateUser(HttpServletRequest request, UserEntity userEntity){
        userService.updateUser(userEntity);
        return new ModelAndView("redirect:/user/list");
    }

    /**
     * 编辑
     * @param id
     * @return
     */
    @RequestMapping("edit")
    public String editUser(ModelMap modelMap, String id){
        UserEntity user = userService.queryUserById(id);
        modelMap.put("user", user);
        return "edit";
    }

    /**
     * 删除
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public ModelAndView deleteUser(HttpServletRequest request, String id){
        userService.deleteUser(id);
        return new ModelAndView("redirect:/user/list");
    }
}
