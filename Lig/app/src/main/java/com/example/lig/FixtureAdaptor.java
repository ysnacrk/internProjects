package com.example.lig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FixtureAdaptor extends ArrayAdapter {
    Context mContext;
    int mResource;

    public FixtureAdaptor(Context context, int resource, List objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Integer tempPos = position + 1;

        ArrayList<String> tempList = new ArrayList<String>();
        tempList = (ArrayList<String>) getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource , parent , false);


        TextView [] fixtureText = new TextView[9];
        TextView week = convertView.findViewById(R.id.week_number);

        fixtureText[0] = convertView.findViewById(R.id.match1);
        fixtureText[1] = convertView.findViewById(R.id.match2);
        fixtureText[2] = convertView.findViewById(R.id.match3);
        fixtureText[3] = convertView.findViewById(R.id.match4);
        fixtureText[4] = convertView.findViewById(R.id.match5);
        fixtureText[5] = convertView.findViewById(R.id.match6);
        fixtureText[6] = convertView.findViewById(R.id.match7);
        fixtureText[7] = convertView.findViewById(R.id.match8);
        fixtureText[8] = convertView.findViewById(R.id.match9);

        week.setText(tempPos.toString() + ". HAFTA");

        for(int i = 0 ; i < 9 ; i++){
            fixtureText[i].setText(tempList.get(i));
        }

        return convertView;
    }
}
