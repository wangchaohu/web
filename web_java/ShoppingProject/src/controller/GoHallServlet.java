package controller;

import bean.Users;
import service.UserService;

import java.io.IOException;

/**
 * Created by wangchaohu on 2017/2/4.
 */
public class GoHallServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");


        Users loginUser = new Users(Integer.parseInt(id), pwd);

        UserService userService = new UserService();

        if (userService.checkUser(loginUser)){
            System.out.print(loginUser.toString());
            //合法用户,跳转到购物大厅
            request.getRequestDispatcher("/WEB-INF/shoppinghall.jsp").forward(request, response);
        }else {
            //不合法用户，跳转到登录
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
