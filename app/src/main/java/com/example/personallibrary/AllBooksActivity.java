package com.example.personallibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecyclerView;
    private BooksRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        adapter=new BooksRecyclerViewAdapter(this);
        booksRecyclerView=findViewById(R.id.bookRecyclerView);
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Book> books=new ArrayList<>();
        books.add(new Book(1,"1Q84","Haruki Murakumi",1350,"https://upload.wikimedia.org/wikipedia/en/b/b9/1Q84bookcover.jpg"
        ,"A work of maddening Briliance","Long Disc"));
        books.add(new Book(2,"Rich Dad Poor Dad","Robert Kiyosaki and Sharon L. Lechter",366,"https://upload.wikimedia.org/wikipedia/en/thumb/b/b9/Rich_Dad_Poor_Dad.jpg/220px-Rich_Dad_Poor_Dad.jpg"
        ,"Personal finance, entrepreneurship, business, investing, economics","Rich Dad Poor Dad is a 1997 book written by Robert Kiyosaki and Sharon Lechter. It advocates the importance of financial literacy (financial education), financial independence and building wealth through investing in assets, real estate investing, starting and owning businesses, as well as increasing one's financial intelligence (financial IQ)"));
        adapter.setBooks(books);


    }
}