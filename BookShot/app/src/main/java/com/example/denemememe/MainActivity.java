package com.example.denemememe;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

//////////_________!!!!!!!!!!!

//ARAMA BUTONU EKLENECEK

public class MainActivity extends AppCompatActivity {

    RecyclerView rc;
    ArrayList<Album> albumList = new ArrayList<Album>();

    Bitmap bitmap;
    Integer REQ = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= 23){
            requestPermissions(new String[] { Manifest.permission.CAMERA , Manifest.permission.WRITE_EXTERNAL_STORAGE} , 2);
        }

        final AlbumAdapter albumAdapter = new AlbumAdapter(this ,albumList);

        rc = findViewById(R.id.recyclerview);
        rc.setAdapter(albumAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rc.setLayoutManager(gridLayoutManager);

        ExtendedFloatingActionButton extendedFloatingActionButton = findViewById(R.id.fab);
        extendedFloatingActionButton.setBackgroundColor(getColor(R.color.colorPrimary));

        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent , REQ);

                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);

                final View mView = getLayoutInflater().inflate(R.layout.diaglog , null);
                final EditText coverName = mView.findViewById(R.id.coverName);

                Button confirm = mView.findViewById(R.id.confirm);
                ImageButton cancel = mView.findViewById(R.id.cancel);

                mBuilder.setView(mView);
                final AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();


                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // burada adapterimize eklemenler yapıo güncellememiz gerekiyor

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String formattedDate = myDateObj.format(myFormatObj);

                        Album album2 = new Album( coverName.getText().toString(), formattedDate , bitmap);
                        albumList.add(album2);
                        alertDialog.cancel();
                        albumAdapter.notifyDataSetChanged();

                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
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
