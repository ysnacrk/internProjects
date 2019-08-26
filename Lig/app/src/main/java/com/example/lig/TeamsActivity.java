package com.example.lig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeamsActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Takımlar");

        Character [] teamlist = new Character[18];

        for (int i = 0 ; i < 18 ; i++){
            teamlist[i] = MainMenu.league.getTeam(i).getTeamName();
        }

        ListView menuList = findViewById(R.id.table_list);
        ArrayAdapter<Character> veriAdaptoru = new ArrayAdapter<Character>(this, android.R.layout.simple_list_item_1, android.R.id.text1, teamlist);
        menuList.setAdapter(veriAdaptoru);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent teamIntent = new Intent(TeamsActivity.this , TeamActivity.class);
                Integer index = i;
                teamIntent.putExtra("teamIndex" , index.toString());
                startActivity(teamIntent);
            }
        });
    }

    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
