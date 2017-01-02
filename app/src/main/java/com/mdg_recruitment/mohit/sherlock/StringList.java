package com.mdg_recruitment.mohit.sherlock;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StringList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    public StringList(Activity context,
                      String[] web) {
        super(context, R.layout.custom_rows, web);
        this.context = context;
        this.web = web;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.season);

        txtTitle.setText(web[position]);
        return rowView;
    }
}