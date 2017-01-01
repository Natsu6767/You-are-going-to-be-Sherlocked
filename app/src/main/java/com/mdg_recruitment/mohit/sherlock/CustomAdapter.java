package com.mdg_recruitment.mohit.sherlock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {


    public CustomAdapter(Context context, String[] epArray) {
        super(context, R.layout.custom_rows, epArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.custom_rows, parent, false);

        String eachEpisode = getItem(position);
        TextView myText = (TextView) customView.findViewById(R.id.episodeno);
        ImageView myImage = (ImageView) customView.findViewById(R.id.episodeimage);


        switch (MainActivity.SEASON){

            case "Season 1" :
                switch (eachEpisode){
                    case "Episode 1" : myImage.setImageResource(R.drawable.s1e1); break;
                    case "Episode 2" : myImage.setImageResource(R.drawable.s1e2); break;
                    case "Episode 3" : myImage.setImageResource(R.drawable.s1e3); break;
                }
                break;
            case "Season 2" :
                switch (MainActivity.EPISODE){
                    case "Episode 1" : myImage.setImageResource(R.drawable.s2e1); break;
                    case "Episode 2" : myImage.setImageResource(R.drawable.s2e2); break;
                    case "Episode 3" : myImage.setImageResource(R.drawable.s2e3); break;
                }
                break;
            case "Season 3" :
                switch (MainActivity.EPISODE){
                    case "Episode 1" : myImage.setImageResource(R.drawable.s3e1); break;
                    case "Episode 2" : myImage.setImageResource(R.drawable.s3e2); break;
                    case "Episode 3" : myImage.setImageResource(R.drawable.s3e3); break;
                }
                break;
        }

        myText.setText(eachEpisode);

        return  customView;

    }
}
