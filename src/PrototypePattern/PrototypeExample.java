package PrototypePattern;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Vehicle implements Cloneable {
//
//    private List<String> vehicleList;
//
//    public Vehicle() {
//        this.vehicleList = new ArrayList<String>();
//    }
//
//    public Vehicle(List<String> list) {
//        this.vehicleList = list;
//    }
//
//    public void insertData() {
//        vehicleList.add("Range Rover");
//        vehicleList.add("BMW");
//        vehicleList.add("Audi");
//        vehicleList.add("Honda");
//        vehicleList.add("Toyota");
//    }
//
//    public List<String> getVehicleList() {
//        return this.vehicleList;
//    }
//
//    public Object clone() throws CloneNotSupportedException {
//        List<String> tempList = new ArrayList<String>();
//
//        for (String s : this.getVehicleList()) {
//            tempList.add(s);
//        }
//        return new Vehicle(tempList);
//    }
//}
//
//class PrototypePatternExample {
//
//    public static void main(String[] args) throws CloneNotSupportedException {
//
//        Vehicle a = new Vehicle();
//        a.insertData();
//
//        Vehicle b = (Vehicle) a.clone();
//        List<String> list = b.getVehicleList();
//        list.add("Range Rover");
//
//        System.out.println(a.getVehicleList()); // [Range Rover, BMW, Audi, Honda, Toyota]
//        System.out.println(list); // [Range Rover, BMW, Audi, Honda, Toyota, Range Rover]
//
//        b.getVehicleList().remove("Audi");
//        System.out.println(list); //[Range Rover, BMW, Honda, Toyota, Range Rover]
//    }
//}

import java.util.ArrayList;
import java.util.List;

class Book {

    private int b_id;
    private String b_name;

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setB_Name(String b_Name) {
        this.b_name = b_Name;
    }

    public int getB_id() {
        return b_id;
    }

    public String getB_name() {
        return b_name;
    }

    @Override
    public String toString() {
        return "Book_Id: " + b_id + ", " + "Book Name: " + b_name;
    }
}

class BookShop implements Cloneable {

    private String ShopName;
    private List<Book> books = new ArrayList<>();

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBooks() {
        for (int x = 1; x <= 10; x++) {
            Book b = new Book();
            b.setB_id(x);
            b.setB_Name("Story " + x);
            getBooks().add(b);
        }
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop shop = new BookShop();

        for (Book b : this.getBooks()) {
            shop.getBooks().add(b);
        }
        return shop;
    }

    @Override
    public String toString() {
        return "Shop Name: " + ShopName + ", " + "Books: " + books;
    }

}

class PrototypeClass {

    public static void main(String[] args) {
        try {
            BookShop shop1 = new BookShop();
            shop1.setShopName("My Shop");
            shop1.addBooks();

            BookShop shop2 = (BookShop) shop1.clone();
            shop1.getBooks().remove(0);

            System.out.println(shop1);// Shop Name: My Shop, Books: [Book_Id: 2, Book Name: Story 2, Book_Id: 3, Book Name: Story 3, Book_Id: 4, Book Name: Story 4, Book_Id: 5, Book Name: Story 5, Book_Id: 6, Book Name: Story 6, Book_Id: 7, Book Name: Story 7, Book_Id: 8, Book Name: Story 8, Book_Id: 9, Book Name: Story 9, Book_Id: 10, Book Name: Story 10]
            System.out.println(shop2); //Shop Name: null, Books: [Book_Id: 1, Book Name: Story 1, Book_Id: 2, Book Name: Story 2, Book_Id: 3, Book Name: Story 3, Book_Id: 4, Book Name: Story 4, Book_Id: 5, Book Name: Story 5, Book_Id: 6, Book Name: Story 6, Book_Id: 7, Book Name: Story 7, Book_Id: 8, Book Name: Story 8, Book_Id: 9, Book Name: Story 9, Book_Id: 10, Book Name: Story 10]

        } catch (CloneNotSupportedException e) {
        }
    }
}
