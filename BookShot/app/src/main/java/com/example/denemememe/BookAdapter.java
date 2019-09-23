package com.example.denemememe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    ArrayList<Book> books;
    LayoutInflater inflater;
    Context mContext;

    public BookAdapter(Context context , ArrayList<Book> books) {
        inflater = LayoutInflater.from(context);
        this.books = books;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.book_card , parent , false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book selectedBook= books.get(position);
        holder.setData(selectedBook , position);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // bu sınıf aldığımız verimizi layoutumuza yani viewmize ekliyoruz

        ImageView bookImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.bookImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        public void setData(Book selectedBook , int position){
            this.bookImage.setImageBitmap(selectedBook .getBookImage());
        }

        @Override
        public void onClick(View view) {

        }
    }
}
