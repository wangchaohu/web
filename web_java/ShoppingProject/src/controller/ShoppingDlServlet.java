package controller;

import service.BookService;
import service.MyCar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangchaohu on 2017/2/8.
 */
public class ShoppingDlServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (String) req.getParameter("id");

        System.out.println(id+"-----------");
        MyCar myCar = (MyCar) req.getSession().getAttribute("myCar");
        myCar.addBook(id, new BookService().getBook(id));

        //将购物车中所有书的集合放入request中，传入到下个界面
        req.setAttribute("bookList", myCar.getAllBooks());

        //将购物车中所有书的总金额，放入request中
        req.setAttribute("totalPrice", myCar.totalPrice());

        req.getRequestDispatcher("/WEB-INF/myShopCar.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);

    }
}
