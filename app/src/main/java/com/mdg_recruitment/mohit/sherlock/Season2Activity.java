package com.mdg_recruitment.mohit.sherlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Season2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season2);

        //Array of String storing seasons
        String[] episodeArray = {"Episode 1", "Episode 2", "Episode 3"};
        //Creates ListAdapter to convert String to List items
        ListAdapter seasonAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, episodeArray);
        //Create ListView object
        ListView season2ListView = (ListView) findViewById(R.id.season2);
        //Add values to list
        season2ListView.setAdapter(seasonAdapter);
    }
}
