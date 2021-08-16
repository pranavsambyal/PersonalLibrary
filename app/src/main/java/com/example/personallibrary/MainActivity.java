package com.example.personallibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnAllBooks,btnAlreadyRead,btnWishlist,btnCurrentlyReading,btnFavorite,btnAbout;
    private TextView title,footer;
    private ImageView logo;
    private static final String TAG = "MainActivity";

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
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AlreadyRead.class);
                startActivity(intent);
            }
        });
        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Reading.class);
                startActivity(intent);
            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Favourite.class);
                startActivity(intent);
            }
        });
        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Wishlist.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and developed by Pranav Singh Sambyal With help form resources available online\n" +
                        "First Full Fledged app, Many more to come");
                builder.setNegativeButton("Dismissed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,website.class);
                        intent.putExtra("url","https://pranavsambyal.github.io/portfolio_site/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
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
        Utilities.getInstance();
    }
}