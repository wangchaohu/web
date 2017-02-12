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
    public void addBook(String id) {

        if (books.containsKey(id)) {
            Books book = books.get(id);
            int nums = book.getShoppingNums();
            System.out.println("购买的书的数量" + (nums++));

            book.setShoppingNums(nums++);
        } else {
            books.put(id, new BookService().getBook(id));
        }
    }

    //删除
    public void delectBook(String id) {
        Books book = books.get(id);
        totalPrice -= book.getPrice() * book.getShoppingNums();
        books.remove(id);
    }

    //更新
    public void updateBook(String id, String nums) {
        Books book = books.get(id);
        book.setShoppingNums(Integer.parseInt(nums));
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
