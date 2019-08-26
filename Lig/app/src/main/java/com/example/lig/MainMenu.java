package com.example.lig;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lig.League.League;


//Main menu başladığında lig oluşuturulsun sonra bunun üzerinden verileri çekeriz

public class MainMenu extends AppCompatActivity {

    public static League league = new League();

    //COMPONENTS
    public TextView name;

    //MENU LIST ITEMS
    String [] menuListItems = {"Takımlar" , "Puan Durumu" , "Fikstür" , "Gol Krallığı"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent menuIntent = getIntent();
        String message = menuIntent.getStringExtra("name");
        league.setLeagueName(message);
        getSupportActionBar().setTitle(message);

        ListView menuList = findViewById(R.id.menu_list);
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, menuListItems);
        menuList.setAdapter(veriAdaptoru);

        //LİG FUNCTIONS
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    league.sortName();
                    Intent teamIntent = new Intent(MainMenu.this , TeamsActivity.class);
                    startActivity(teamIntent);
                }
                else if(i == 1){
                    Intent tableIntent = new Intent(MainMenu.this , TableActivity.class);
                    startActivity(tableIntent);
                }
                else if(i == 2){
                    Intent fixtureIntent = new Intent(MainMenu.this , FixtureActivity.class);
                    startActivity(fixtureIntent);
                }
            }
        });
    }
}
