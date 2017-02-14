package controller;

import service.MyCar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangchaohu on 2017/2/14.
 *
 *
 * 防止用户刷新界面，导致重复购买
 *
 *
 * 将要准备的数据放入里面
 *
 */
public class GoShowMyCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyCar myCar = (MyCar) req.getSession().getAttribute("myCar");

        //将购物车中所有书的集合放入request中，传入到下个界面
        req.setAttribute("bookList", myCar.getAllBooks());
        //将购物车中所有书的总金额，放入request中
        req.setAttribute("totalPrice", myCar.totalPrice());

        req.getRequestDispatcher("/WEB-INF/myShopCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
