package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangchaohu on 2017/1/16.
 */

@Service
public class LoginService {

    public ModelAndView doLogin(String loginPageUrl, String successPageUrl, String username, String password){
        if (null == username && "".equals(username)){
            return new ModelAndView(loginPageUrl, "error", "用户名不能为空");
        }

        if (null == password && "".equals(password)){
            return new ModelAndView(loginPageUrl, "error", "密码不能为空");
        }

        if (username.equals("admin") && password.equals("123")){

            return new ModelAndView(successPageUrl);
        }

        return new ModelAndView(loginPageUrl, "error", "用户名或密码错误");
    }
}
