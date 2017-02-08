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

    /**提供一个方法，根据书的id号，返回书的全部信息*/
    public Books getBook(String id){
        Books books = new Books();
        //根据id返回的书，有且只有一本
        ArrayList<String[]> bookList = LiteSql.getInstance().querySqlRL("select * from books where id = " + id);

        if (bookList.size() == 1){
            books.setId(Integer.parseInt(book[0]));
            books.setName(book[1]);
            books.setAuthor(book[2]);
            books.setPrice(Float.parseFloat(book[4]));
            books.setPublishHouse(book[3]);
            books.setNums(Integer.parseInt(book[5]));
        }
        return books;
    }

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
