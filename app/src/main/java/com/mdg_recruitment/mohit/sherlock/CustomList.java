package com.mdg_recruitment.mohit.sherlock;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] name;
    private final Integer[] imageId;
    public CustomList(Activity context, String[] web, Integer[] imageId) {
        super(context, R.layout.custom_rows, web);
        this.context = context;
        this.name = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.custom_rows, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.episodeno);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.episodeimage);
        txtTitle.setText(name[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}