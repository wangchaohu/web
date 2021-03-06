package service;

import bean.Books;
import bean.Users;
import utils.LiteSql;

import java.sql.*;
import java.sql.Date;
import java.util.*;


/**
 * Created by wangchaohu on 2017/2/13.
 */
public class OrderService {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void submitOrder(MyCar myCar, Users users){

        //插入到order表
        String sql = " INSERT INTO orders (userId, totalPrice,orderDate) VALUES (?,?,?)";

        try {
            conn = LiteSql.getInstance().getConn();

            //为了保证不会出现订单混乱，将数据的事务隔离级别提升到最高
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            //插入订单表
            ps = conn.prepareStatement(sql);
            ps.setInt(1, users.getId());
            ps.setFloat(2, myCar.totalPrice());
            java.util.Date date = new java.util.Date();
            ps.setDate(3, new Date(date.getTime()));
            ps.execute();

            sql = "SELECT orderId FROM orders";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int orderId = 0;
            if (rs.next()){
                orderId = rs.getInt(1);
            }
            sql = "INSERT INTO orderDetails (orderId, bookId, bookNum) VALUES (?, ?,?)";
            ps = conn.prepareStatement(sql);
            ArrayList<Books> al = myCar.getAllBooks();
            for (Books book:al) {
                ps.setInt(1, orderId);
                ps.setInt(2, book.getId());
                ps.setInt(3, book.getShoppingNums());
                ps.execute();
            }
            conn.commit();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
