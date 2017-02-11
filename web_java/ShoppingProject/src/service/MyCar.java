package service;

import bean.Books;

import java.util.*;

/**
 * Created by wangchaohu on 2017/2/8.
 */
public class MyCar {

    HashMap<String, Books> books = new HashMap<>();
    float totalPrice = 0.0f;

    //添加
    public void addBook(String id, Books book) {
        if (books.containsKey(id)) {
            int shoppingNums = book.getShoppingNums();
            shoppingNums += 1;
            System.out.println(shoppingNums);
            book.setShoppingNums(shoppingNums);
        }
        books.put(id, book);

    }

    //删除
    public void delectBook(String id, Books book) {
        totalPrice -= book.getPrice() * book.getShoppingNums();
        books.remove(id);
    }

    //更新
    public void updateBook() {

    }

    //得到购物车中所有的书
    public ArrayList<Books> getAllBooks() {

        ArrayList<Books> booksList = new ArrayList<>();
        Iterator iterator = books.keySet().iterator();

        while (iterator.hasNext()) {
            String id = (String) iterator.next();
            booksList.add(books.get(id));
        }
        return booksList;
    }

    //清空
    public void removeAllBook() {
        books.clear();
    }

    //购物车总价格
    public float totalPrice() {

        totalPrice = 0.0f;
        ArrayList<Books> al = getAllBooks();
        for (int i = 0; i < al.size(); i++) {
            totalPrice += al.get(i).getPrice() * al.get(i).getShoppingNums();
        }

        return totalPrice;
    }
}
