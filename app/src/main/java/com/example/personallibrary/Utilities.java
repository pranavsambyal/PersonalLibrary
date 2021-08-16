package com.example.personallibrary;

import java.util.ArrayList;

public class Utilities {
    private static Utilities instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> readBooks;
    private static ArrayList<Book> readingBooks;
    private static ArrayList<Book> favBooks;
    private static ArrayList<Book> wantedBooks;

    private Utilities() {
        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }
        if(null==readBooks){
            readBooks=new ArrayList<>();
        }
        if(null==readingBooks){
            readingBooks=new ArrayList<>();
        }

        if(null==favBooks){
            favBooks=new ArrayList<>();
        }

        if(null==wantedBooks){
            wantedBooks=new ArrayList<>();
        }
    }

    private void initData() {
        //todo:Add initial data
        allBooks.add(new Book(1,"1Q84","Haruki Murakumi",1350,"https://upload.wikimedia.org/wikipedia/en/b/b9/1Q84bookcover.jpg"
                ,"A work of maddening Briliance","Long Disc"));
        allBooks.add(new Book(2,"Rich Dad Poor Dad","Robert Kiyosaki and Sharon L. Lechter",366,"https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Rich_Dad_Poor_Dad.jpg/220px-Rich_Dad_Poor_Dad.jpg"
                ,"Personal finance, entrepreneurship, business, investing, economics","Rich Dad Poor Dad is a 1997 book written by Robert Kiyosaki and Sharon Lechter. It advocates the importance of financial literacy (financial education), financial independence and building wealth through investing in assets, real estate investing, starting and owning businesses, as well as increasing one's financial intelligence (financial IQ)"));

    }

    public static  Utilities getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utilities();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getReadBooks() {
        return readBooks;
    }

    public static ArrayList<Book> getReadingBooks() {
        return readingBooks;
    }

    public static ArrayList<Book> getFavBooks() {
        return favBooks;
    }

    public static ArrayList<Book> getWantedBooks() {
        return wantedBooks;
    }
    public Book getBookById(int id){
        for (Book b:allBooks) {
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
}
