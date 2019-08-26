package com.example.lig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class PlayersFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TeamActivity ta = (TeamActivity) getActivity();
        View view = inflater.inflate(R.layout.players_fragment , container  , false);

        ListView fixtureListView = view.findViewById(R.id.team_player_list);
        ArrayList<Character> fixtureList = new ArrayList<Character>();

        for (int i = 0; i < 17; i++) {
            fixtureList.add(MainMenu.league.getTeam(Integer.parseInt(ta.getIndex())).Fixture.get(i));
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1,fixtureList);
        fixtureListView.setAdapter(adapter);


        return view;
    }
}
