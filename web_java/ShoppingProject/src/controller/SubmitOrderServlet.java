package controller;


import bean.Users;
import service.MyCar;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by wangchaohu on 2017/2/13.
 */
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = (Users) req.getSession().getAttribute("user");
        MyCar myCar = (MyCar) req.getSession().getAttribute("myCar");

        OrderService orderService = new OrderService();
        try {
            //存入order表中
            orderService.submitOrder(myCar, users);
            req.getRequestDispatcher("/WEB-INF/OrderSuccess.jsp").forward(req, resp);
        }catch (RuntimeException e){
            //错误，跳转到错误界面
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
