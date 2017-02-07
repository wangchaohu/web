package service;

import bean.Books;
import utils.LiteSql;

import java.util.ArrayList;

/**
 * Created by wangchaohu on 2017/2/4.
 */
public class BookService {

    ArrayList<String[]> bookses = null;
    String[] book = null;

    ArrayList<Books> books_list = null;

    public ArrayList<Books> getAllBook(){
        bookses = (ArrayList<String[]>) LiteSql.getInstance().querySqlRL("select * from books");
        books_list = new ArrayList<>();
        if (null != bookses && !bookses.isEmpty()){
            for (int i = 0; i < bookses.size(); i++){

                //对book二次封装
                book = bookses.get(i);
                Books books = new Books();
                books.setId(Integer.parseInt(book[0]));
                books.setName(book[1]);
                books.setAuthor(book[2]);
                books.setPrice(Float.parseFloat(book[4]));
                books.setPublishHouse(book[3]);
                books.setNums(Integer.parseInt(book[5]));
                books_list.add(books);
            }
        }
        return books_list;
    }
}
