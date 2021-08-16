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
        //todo:Make data persistence and load from database
        allBooks.add(new Book(1,"Harry Potter and the Philosopher’s Stone","J.K. Rowling",223,"https://www.oberlo.com/media/1603897577-image22-1.jpg?fm=webp&w=1824&fit=max"
                ,"Best Book of Harry Potter Series  ","Harry Potter and the Philosopher's Stone is an enthralling start to Harry's journey toward coming to terms with his past and facing his future. It was the first book written by Rowling, and she was praised for creating well-rounded characters and a fully realized wizard universe that coexisted with the present world."));
        allBooks.add(new Book(2,"Rich Dad Poor Dad","Robert Kiyosaki and Sharon L. Lechter",366,"https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Rich_Dad_Poor_Dad.jpg/220px-Rich_Dad_Poor_Dad.jpg"
                ,"Personal finance, entrepreneurship, business, investing, economics","Rich Dad Poor Dad is a 1997 book written by Robert Kiyosaki and Sharon Lechter. It advocates the importance of financial literacy (financial education), financial independence and building wealth through investing in assets, real estate investing, starting and owning businesses, as well as increasing one's financial intelligence (financial IQ)"));
        allBooks.add(new Book(2,"The Power of your Subconscious Mind"," Joseph Murphy",312,"https://images-na.ssl-images-amazon.com/images/I/51QTTApN-XL._SX324_BO1,204,203,200_.jpg"
        ,"An ideal book to unravel your sub-conscious","The Power of Your Subconscious Mind explains how we can access the untapped potential of our subconscious mind. Accessing our subconscious mind can make us happier and wiser. Plus, it has the potential to lower mortality rates, help you make money, and assist you in finding the love of your life."));
        allBooks.add(new Book(3,"The Lord of the Rings","J. R. R. Tolkien",1178,"https://upload.wikimedia.org/wikipedia/en/thumb/e/e9/First_Single_Volume_Edition_of_The_Lord_of_the_Rings.gif/220px-First_Single_Volume_Edition_of_The_Lord_of_the_Rings.gif",
                " Work of Fiction which feels like reality","The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore."));
        allBooks.add(new Book(5,"To Kill a Mockingbird","Harper Lee",281,"https://www.powells.com/portals/0/images/9780061120084.jpg",
                "To Kill a Mockingbird has become a classic of modern American literature, winning the Pulitzer Prize","While To Kill a Mockingbird is a favorite book of pretty much everyone who has read it, it's important to remember that it continues to be subversive and challenging to the status quo. The protagonist is a young girl named Scout and except for her father, all the main characters in the book are marginalized by the power structure of their town — a structure that still exists nearly everywhere — where wealthy white men control the lives of everyone else, and even the members of that group who want to use their status for something honorable, like Scout's father Atticus, cannot win against the flattening wave of that power. Until something about that structure really changes, this book will remain required reading for every person in America."));
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
    public boolean addToRead(Book book){
        return readBooks.add(book);
    }
    public boolean addToReading(Book book){
        return readingBooks.add(book);
    }
    public boolean addbook(Book book){
        return allBooks.add(book);
    }
    public boolean addToFav(Book book){
        return favBooks.add(book);
    }
    public boolean addToWishlist(Book book){
        return wantedBooks.add(book);
    }


    public boolean removeFromRead(Book book){
        return readBooks.remove(book);
    }
    public boolean removeFromReading(Book book){
        return readingBooks.remove(book);
    }
    public boolean removeFromFav(Book book){
        return favBooks.remove(book);
    }
    public boolean removeFromWishlist(Book book){
        return wantedBooks.remove(book);
    }
}
