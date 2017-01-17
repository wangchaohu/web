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


    @RequestMapping("/index.html")               //这里的注解参数  是请求这个视图的后缀，比如http://localhost:8080/index.html和(login.jsp)访问同一视图
    public ModelAndView toLoginPage(){
        return new ModelAndView("/login.jsp");
    }

    @RequestMapping("/Login")         //这里注解参数  要和视图中请求的方法名对应
    public ModelAndView doLogin(){
        String loginPageUrl = "/login.jsp";          //若在spring-servlet中配置了ViewResolver的两个参数，则不必在这里加入后缀.jsp
        String successPageUrl = "/success.jsp";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return service.doLogin(loginPageUrl, successPageUrl, username, password);

    }

}
