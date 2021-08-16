package com.example.personallibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        String longdisc="yp" +
                "ypesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.esetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        //TODO: get data form recycler view
        Book book= new Book(1,"1Q84","Haruki Murakumi",1350,"https://upload.wikimedia.org/wikipedia/en/b/b9/1Q84bookcover.jpg"
                ,"A work of maddening Briliance",longdisc);
        Intent intent=getIntent();
        if(null!=intent){
            int bookId=intent.getIntExtra(BOOK_ID,-1);
            if(bookId!=-1){

            }

        }
        setData(book);
    }
    private void setData(Book book){
        title.setText(book.getName());
        author.setText(book.getAuthor());
        txtpage.setText(String.valueOf(book.getPages()));
        shortDesc.setText(book.getShortDesc());
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