package com.example.denemememe;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    RecyclerView rc;
    Bitmap bitmap;
    Integer REQ = 1;
    ArrayList <Book> bookList = new ArrayList<>();

    // burada resim eklemek butonumuz olacka albüm ekleme gibi
    // resimleri yine card view tarzı alabiliriz

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Intent menuIntent = getIntent();
        String message = menuIntent.getStringExtra("name");
        getSupportActionBar().setTitle(message);
        //  GERİ BUTONU EKLENECEK


        final BookAdapter bookAdapter = new BookAdapter(AlbumActivity.this ,bookList);

        rc = findViewById(R.id.recyclerview_album);
        rc.setAdapter(bookAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rc.setLayoutManager(gridLayoutManager);

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab_book);
        extendedFloatingActionButton.setBackgroundColor(getColor(R.color.colorPrimary));

        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent , REQ);
                Book book = new Book(bitmap);
                bookList.add(book);
                bookAdapter.notifyDataSetChanged();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK ){
            if(requestCode == 1){
                Bundle bundle = data.getExtras();
                bitmap = (Bitmap) bundle.get("data");
            }

        }
    }

}
