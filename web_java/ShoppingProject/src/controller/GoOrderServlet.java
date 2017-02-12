package controller;

import bean.Users;
import service.MyCar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangchaohu on 2017/2/12.
 */
public class GoOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到用户
        Users users = (Users) req.getSession().getAttribute("user");
        //得到购物车
        MyCar myCar = (MyCar) req.getSession().getAttribute("myCar");

        req.setAttribute("shoppingBooks", myCar.getAllBooks());
        req.setAttribute("shoppingBooksPrice",myCar.totalPrice());


        req.getRequestDispatcher("/WEB-INF/myOrder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
