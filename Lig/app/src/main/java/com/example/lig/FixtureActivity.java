package com.example.lig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class FixtureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);

        getSupportActionBar().setTitle("Fikstür");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<ArrayList<String>> fixtureList = new ArrayList<ArrayList<String>>();

        ArrayList<Character> tempListTeam = new ArrayList<Character>();

        String Tag = "   :   ";

        for (int i = 0; i < 17; i++) {
            ArrayList<String> tempList = new ArrayList<String>();
            for (int j = 0; j < 18; j++) {
                tempListTeam.add(MainMenu.league.getTeam(j).getTeamName());
                if(!tempListTeam.contains(MainMenu.league.getTeam(j).Fixture.get(i))){

                    tempList.add(MainMenu.league.getTeam(j).getTeamName() + Tag + MainMenu.league.getTeam(j).Fixture.get(i));

                }
            }
            fixtureList.add(tempList);
            tempListTeam.clear();
        }

        for (int i = 0; i < 17; i++) {
            ArrayList<String> tempList = new ArrayList<String>();
            for (int j = 0; j < 18; j++) {
                tempListTeam.add(MainMenu.league.getTeam(j).getTeamName());
                if(!tempListTeam.contains(MainMenu.league.getTeam(j).Fixture.get(i))){

                    tempList.add(MainMenu.league.getTeam(j).Fixture.get(i) + Tag + MainMenu.league.getTeam(j).getTeamName());

                }
            }
            fixtureList.add(tempList);
            tempListTeam.clear();
        }

        ListView fixtureView = findViewById(R.id.fixture_list);
        FixtureAdaptor adaptor = new FixtureAdaptor(this , R.layout.fixture_layout , fixtureList);
        fixtureView.setAdapter(adaptor);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
