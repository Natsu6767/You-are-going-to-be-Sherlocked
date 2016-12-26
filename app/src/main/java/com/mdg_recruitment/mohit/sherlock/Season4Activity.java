package com.mdg_recruitment.mohit.sherlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Season4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season4);

        //Array of String storing seasons
        String[] episodeArray = {"Episode 0", "Episode 1", "Episode 2", "Episode 3"};
        //Creates ListAdapter to convert String to List items
        ListAdapter seasonAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, episodeArray);
        //Create ListView object
        ListView season4ListView = (ListView) findViewById(R.id.season4);
        //Add values to list
        season4ListView.setAdapter(seasonAdapter);
    }
}
