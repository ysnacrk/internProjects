package com.example.lig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;

import com.example.lig.League.Player;
import com.google.android.material.tabs.TabLayout;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {

    public String getIndex() {
        return index;
    }

    private String index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        Context context = this;

        Intent teamIntent = getIntent();
        index = teamIntent.getStringExtra("teamIndex");

        Bundle bundle = new Bundle();
        bundle.putString("index" , index);

        FixtureFragment fragobj = new FixtureFragment();
        fragobj.setArguments(bundle);

        PlayersFragment playerobj = new PlayersFragment();
        playerobj.setArguments(bundle);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(MainMenu.league.getTeam(Integer.parseInt(index)).getTeamName().toString());

        TextView attackView = findViewById(R.id.team_attack_power);
        TextView midfieldView = findViewById(R.id.team_midfield_power);
        TextView defenceView = findViewById(R.id.team_defence_power);

        attackView.setText(String.valueOf(MainMenu.league.getTeam(Integer.parseInt(index)).getAttackPower()));
        midfieldView.setText(String.valueOf(MainMenu.league.getTeam(Integer.parseInt(index)).getMidPower()));
        defenceView.setText(String.valueOf(MainMenu.league.getTeam(Integer.parseInt(index)).getDefencePower()));

        TabLayout tabLayout = findViewById(R.id.team_tablayout);
        ViewPager viewPager = findViewById(R.id.team_view_pager);

        viewPager.setAdapter(new PageAdaptor(getSupportFragmentManager() ,context ));
        tabLayout.setupWithViewPager(viewPager );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
