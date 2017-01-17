package com.example.controller;

import com.example.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangchaohu on 2017/1/16.
 */

@Controller
public class LoginController {

    @Resource
    LoginService service;

    @Resource
    HttpServletRequest request;


    @RequestMapping("index")
    public ModelAndView toLoginPage(){
        return new ModelAndView("/login.jsp");
    }

    @RequestMapping("login")
    public ModelAndView doLogin(){
        String loginPageUrl = "login.jsp";
        String successPageUrl = "success.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return service.doLogin(loginPageUrl, successPageUrl, username, password);

    }
}
