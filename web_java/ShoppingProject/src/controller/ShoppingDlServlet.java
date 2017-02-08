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
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        MyCar myCar = (MyCar) req.getSession().getAttribute("myCar");
        myCar.addBook(id, new BookService().getBook(id));

        req.getRequestDispatcher("/WEB-INF/myShopCar.jsp").forward(req, resp);
    }
}
