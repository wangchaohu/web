package utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by wangchaohu on 2017/2/6.
 */
public class LiteSql {
    private String dbDriver="com.mysql.jdbc.Driver";
    private String dbUrl="jdbc:mysql://127.0.0.1:3306/bookShop";
    private String dbUser = "root";
    private String dbPwd = "zx1115hx";
    private Connection sqlConn = null;

    /**
     * 单例模式
     * */

    private static class LiteSqlHolder{

        private static final LiteSql liteSql = new LiteSql();
    }

    public static LiteSql getInstance(){
        return LiteSqlHolder.liteSql;
    }


    public Connection getConn(){


        try {
            Class.forName(dbDriver);
        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }

        try {
            sqlConn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        }catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
        return sqlConn;
    }

    /**
     * 查询数据库
     * 如果有将他们保存在List中
     * @return resultLists
     * */

    public ArrayList querySqlRL(String querySql){


        ArrayList<String[]> resultLists = null;

        Connection conn = getConn();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(querySql);
            resultLists = new ArrayList();
            while (rs.next()){
                ResultSetMetaData data = rs.getMetaData();

                String[] objectses = new String[data.getColumnCount()];
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    objectses[i-1] = rs.getString(data.getColumnName(i));
                }
                resultLists.add(objectses);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close();
        }

        return resultLists;
    }

    /**
     * 查询数据库
     * 如果有数据，返回true，反之，返回false
     * */

    public boolean querySqlRB(){
        String querySql = "select * from users where id = 100";

        Connection conn = getConn();

        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(querySql);
            if (rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public void close(){
        try {
        sqlConn.close();}
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
