package service;

import bean.Books;

import java.util.*;

/**
 * Created by wangchaohu on 2017/2/8.
 */
public class MyCar {

    HashMap<String, Books> books = new HashMap<>();

    //添加
    public void addBook(String id, Books book){
        if (books.containsKey(id)){
            int shoppingNums = book.getShoppingNums();
            book.setShoppingNums(shoppingNums+1);
        }
        books.put(id, book);
    }
    //删除
    public void delectBook(String id){
        books.remove(id);
    }
    //更新
    public void updateBook(){

    }
    //得到购物车中所有的书
    public ArrayList<Books> getAllBooks(){

        ArrayList<Books> booksList = new ArrayList<>();
        Iterator iterator = books.keySet().iterator();

        while (iterator.hasNext()){
            String id = (String)iterator.next();
            booksList.add(books.get(id));
        }
        return booksList;
    }
    //清空
    public void removeAllBook(){
        books.clear();
    }

    //购物车总价格
    public float totalPrice(){

        float totalPrice = 0.0f;

        ArrayList<Books> al = getAllBooks();
        for (int i = 0; i < al.size(); i++){
            totalPrice += al.get(i).getPrice() * al.get(i).getShoppingNums();
        }

        return totalPrice;
    }
}
