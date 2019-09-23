package com.example.denemememe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {

    ArrayList<Album> albums ;
    LayoutInflater inflater;
    Context mContext;

    public AlbumAdapter(Context context , ArrayList<Album> albums) {
        inflater = LayoutInflater.from(context);
        this.albums = albums;
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card , parent , false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Album selectedAlbum = albums.get(position);
        holder.setData(selectedAlbum , position);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // bu sınıf aldığımız verimizi layoutumuza yani viewmize ekliyoruz

        TextView albumName , albumDate;
        ImageView cover;
        ImageButton options;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            albumName = itemView.findViewById(R.id.albumName);
            albumDate = itemView.findViewById(R.id.creationDate);
            options = itemView.findViewById(R.id.options);
            cover = itemView.findViewById(R.id.coverImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent albumIntent = new Intent(mContext.getApplicationContext(), AlbumActivity.class);
                    albumIntent.putExtra("name" , albumName.getText().toString());
                    mContext.startActivity(albumIntent);

                }
            });
            options.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        //pass
                }
            });
        }

        public void setData(Album selectedAlbum , int position){
            this.albumName.setText(selectedAlbum.getName());
            this.albumDate.setText(selectedAlbum.getDate());
            this.cover.setImageBitmap(selectedAlbum.getCover());
        }


        @Override
        public void onClick(View view) {
            //burada gideceği rotayı belirtecez
            System.out.print("Tik");
        }
    }
}
