package service;

import bean.Books;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wangchaohu on 2017/2/8.
 */
public class MyCar {

    HashMap<String, Books> books = new HashMap<>();

    //添加
    public void addBook(String id, Books book){
        books.put(id,book);
    }
    //删除
    public void delectBook(String id){
        books.remove(id);
    }
    //更新
    public void updateBook(){

    }
    //清空
    public void removeAllBook(){
        books.clear();
    }
}
