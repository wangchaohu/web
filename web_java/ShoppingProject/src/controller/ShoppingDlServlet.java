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

        MyCar myCar = (MyCar) req.getSession().getAttribute("myCar");
        if (req.getParameter("type").equals("delBook")) {

            String delectId = req.getParameter("delectId") + "";

            System.out.print("删除的书的id===" + delectId);
            myCar.delectBook(delectId);

            //将购物车中所有书的集合放入request中，传入到下个界面
            req.setAttribute("bookList", myCar.getAllBooks());
            //将购物车中所有书的总金额，放入request中
            req.setAttribute("totalPrice", myCar.totalPrice());

            req.getRequestDispatcher("/WEB-INF/myShopCar.jsp").forward(req, resp);
        }

        if (req.getParameter("type").equals("addBook")) {
            String id = req.getParameter("id");
            myCar.addBook(id);
            //将购物车中所有书的集合放入request中，传入到下个界面
            req.setAttribute("bookList", myCar.getAllBooks());
            //将购物车中所有书的总金额，放入request中
            req.setAttribute("totalPrice", myCar.totalPrice());
            req.getRequestDispatcher("/WEB-INF/myShopCar.jsp").forward(req, resp);
        }

        if (req.getParameter("type").equals("returnHall")) {
            req.setAttribute("books", new BookService().getAllBook());
            req.getRequestDispatcher("WEB-INF/shoppinghall.jsp").forward(req, resp);
        }
        if (req.getParameter("type").equals("update")) {
            //得到每本书的书号
            String[] id = req.getParameterValues("id");
            //得到每本书的数量
            String[] shoppingNums = req.getParameterValues("bookNum");
//            myCar.updateBook(id[], shoppingNums)
            for (int i = 0; i < id.length; i++) {
                myCar.updateBook(id[i], shoppingNums[i]);
            }
            //将购物车中所有书的集合放入request中，传入到下个界面
            req.setAttribute("bookList", myCar.getAllBooks());
            //将购物车中所有书的总金额，放入request中
            req.setAttribute("totalPrice", myCar.totalPrice());
            req.getRequestDispatcher("/WEB-INF/myShopCar.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
