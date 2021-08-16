package com.example.personallibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public  static final String BOOK_ID="bookId";
    private TextView title,author,txtpage,shortDesc,longDesc;
    private Button btnAddToWishlist,btnAddToRead,btnAddToCurrentlyReading,btnAddToFavourite;
    private ImageView bookimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        init();
        Intent intent=getIntent();
        if(null!=intent){
            int bookId=intent.getIntExtra(BOOK_ID,-1);
            if(bookId!=-1){
                Book retrivedBook =Utilities.getInstance().getBookById(bookId);
                if(null!=retrivedBook){
                    setData(retrivedBook);
                    handleAlreadyRead(retrivedBook);
                    handleWantToRead(retrivedBook);
                    handleCuirrentlyReading(retrivedBook);
                    handleFav(retrivedBook);
                }
            }
        }
    }



    /**
     * Adds book to already read list and disable button when book is added added in the list
     * @param book
     */
    private void handleAlreadyRead(Book book){
        ArrayList<Book> alreadyReadBooks=Utilities.getInstance().getReadBooks();
        boolean existalready=false;
        for( Book b : alreadyReadBooks){
            if(b.getId()==book.getId()){
                existalready=true;
            }
        }
        if(existalready){
            btnAddToRead.setEnabled(false);
        }
        else {
            btnAddToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utilities.getInstance().addToRead(book)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(BookActivity.this,AlreadyRead.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Exception occurred try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }
    /**
     * Adds book to want to read list and disable button when book is added added in the list
     * @param book
     */
    private void handleWantToRead(Book book) {
        ArrayList<Book> wantedBooks=Utilities.getInstance().getWantedBooks();
        boolean existalready=false;
        for( Book b : wantedBooks){
            if(b.getId()==book.getId()){
                existalready=true;
            }
        }
        if(existalready){
            btnAddToWishlist.setEnabled(false);
        }
        else {
            btnAddToWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utilities.getInstance().addToWishlist(book)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(BookActivity.this,Wishlist.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Exception occurred try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }

    }
    /**
     * Adds book to fav book list and disable button when book is added added in the list
     * @param book
     */
    private void handleFav(Book book) {
        ArrayList<Book> favBooks=Utilities.getInstance().getFavBooks();
        boolean existalready=false;
        for( Book b : favBooks){
            if(b.getId()==book.getId()){
                existalready=true;
            }
        }
        if(existalready){
            btnAddToFavourite.setEnabled(false);
        }
        else {
            btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utilities.getInstance().addToFav(book)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(BookActivity.this,Wishlist.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Exception occurred try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    /**
     * Adds book to currently reading book list and disable button when book is added added in the list
     * @param book
     */
    private void handleCuirrentlyReading(Book book) {
        ArrayList<Book> readingBooks=Utilities.getInstance().getReadingBooks();
        boolean existalready=false;
        for( Book b : readingBooks){
            if(b.getId()==book.getId()){
                existalready=true;
            }
        }
        if(existalready){
            btnAddToCurrentlyReading.setEnabled(false);
        }
        else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utilities.getInstance().addToReading(book)){
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(BookActivity.this,Reading.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Exception occurred try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void setData(Book book){
        title.setText(book.getName());
        author.setText(book.getAuthor());
        txtpage.setText(String.valueOf(book.getPages()));
        longDesc.setText(book.getLongDesc());
        Glide.with(title)
        .asBitmap().load(book.getImgUrl())
        .into(bookimg);

    }
    private void init(){
        title=findViewById(R.id.title);
        author=findViewById(R.id.bookauthor);
        txtpage=findViewById(R.id.pagecount);
        shortDesc=findViewById(R.id.shortDesc);
        longDesc=findViewById(R.id.longDesc);

        btnAddToCurrentlyReading=findViewById(R.id.btnReading);
        btnAddToRead=findViewById(R.id.btnRead);
        btnAddToFavourite=findViewById(R.id.btnAddFav);
        btnAddToWishlist=findViewById(R.id.btnWant);

        bookimg=findViewById(R.id.bookImg);
    }
}