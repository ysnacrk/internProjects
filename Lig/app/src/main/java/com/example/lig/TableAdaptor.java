package com.example.lig;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.lig.League.Team;

import java.util.ArrayList;


public class TableAdaptor extends ArrayAdapter<Team> {

    private  Context mContext;
    private int mResource;

    public TableAdaptor(Context context, int resource, ArrayList<Team> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Integer tempPos = position + 1;
        Character tempName = getItem(position).getTeamName();

        String mPosition = tempPos.toString();
        String mName = tempName.toString();
        String mAverage = getItem(position).getAverage().toString();
        String mPoint = getItem(position).getPoint().toString();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource , parent , false);

        TextView textRank = convertView.findViewById(R.id.rank);
        textRank.setText(mPosition);

        TextView textName = convertView.findViewById(R.id.team_name_table);
        textName.setText(mName);

        TextView textAverage = convertView.findViewById(R.id.average);
        textAverage.setText(mAverage);

        TextView textPoint = convertView.findViewById(R.id.point);
        textPoint.setText(mPoint);

        return convertView;
    }
}
