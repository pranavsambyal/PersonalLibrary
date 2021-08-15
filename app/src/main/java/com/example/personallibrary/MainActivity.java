package com.example.personallibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnAllBooks,btnAlreadyRead,btnWishlist,btnCurrentlyReading,btnFavorite,btnAbout;
    private TextView title,footer;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        btnAllBooks=findViewById(R.id.btnAllBooks);
        btnAlreadyRead=findViewById(R.id.btnAlreadyRead);
        btnCurrentlyReading=findViewById(R.id.btnCurrentyReading);
        btnWishlist=findViewById(R.id.btnWishlist);
        btnFavorite=findViewById(R.id.btnFav);
        btnAbout=findViewById(R.id.btnAbout);
    }
}