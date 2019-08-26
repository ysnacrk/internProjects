package com.example.lig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.lig.League.Team;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        getSupportActionBar().setTitle("Puan Tablosu");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView tableList = findViewById(R.id.table_list);

        ArrayList<Team> teamList = new ArrayList<Team>();

        for(int i = 0 ; i < MainMenu.league.getLength() ; i++){
            teamList.add(MainMenu.league.getTeam(i));
        }

        TableAdaptor adaptor = new TableAdaptor(this , R.layout.raw_layout , teamList);
        tableList.setAdapter(adaptor);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        else if(item.getItemId() == R.id.table_menu_sort_average){
            MainMenu.league.sortAverage();
            finish();
            startActivity(getIntent());
        }
        else if(item.getItemId() == R.id.table_menu_sort_point){
            MainMenu.league.sortPoint();
            finish();
            startActivity(getIntent());
        }
        else if(item.getItemId() == R.id.table_menu_sort_name){
            MainMenu.league.sortName();
            finish();
            startActivity(getIntent());
        }
        else if(item.getItemId() == R.id.table_menu_sort_overall){
            MainMenu.league.sortOverall();
            finish();
            startActivity(getIntent());
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.table_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }


}
