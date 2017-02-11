package bean;

/**
 * Created by wangchaohu on 2017/2/4.
 */
public class Books {

    private int id;
    private String name;
    private String author;
    private String publishHouse;
    private float price;
    private int nums;
    private int shoppingNums = 0;   //购买书的数量,默认为1本

    public int getShoppingNums() {
        return shoppingNums;
    }

    public void setShoppingNums(int shoppingNums) {
        this.shoppingNums = shoppingNums;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
