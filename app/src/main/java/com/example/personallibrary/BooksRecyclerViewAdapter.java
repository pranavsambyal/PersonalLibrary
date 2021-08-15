package com.example.personallibrary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter<BooksRecyclerViewAdapter.Viewholder> {
    private static final String TAG = "BRecyclerViewAdapter";
    private ArrayList<Book> books=new ArrayList<>();
    private Context mContext;

    public BooksRecyclerViewAdapter(Context mContext) {

        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.name.setText(books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImgUrl())
                .into(holder.imgBook);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, books.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: called");
            }
        });
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDesc.setText(books.get(position).getShortDesc());

        if(books.get(position).getExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.darrow.setVisibility(View.GONE);
        }
        else
        {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.darrow.setVisibility(View.VISIBLE);
        }

        

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView name;


        private ImageView  darrow,uarrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor,txtDesc;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            parent=itemView.findViewById(R.id.parent);
            imgBook=itemView.findViewById(R.id.imgBook);
            name=itemView.findViewById(R.id.bookName);

            darrow=itemView.findViewById(R.id.btnDownArrow);
            uarrow=itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout=itemView.findViewById(R.id.expandedRelativeLayout);
            txtAuthor=itemView.findViewById(R.id.txtAuthor);
            txtDesc=itemView.findViewById(R.id.decs);

            darrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book=books.get(getAdapterPosition());
                    book.setExpanded(!book.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            uarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book=books.get(getAdapterPosition());
                    book.setExpanded(!book.getExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
