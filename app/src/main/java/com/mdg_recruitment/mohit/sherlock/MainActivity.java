package com.mdg_recruitment.mohit.sherlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array of String storing seasons
        String[] seasonArray = {"Season 1", "Season 2", "Season 3", "Season 4"};
        //Creates ListAdapter to convert String to List items
        ListAdapter seasonAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seasonArray);
        //Create ListView object
        ListView seasonListView = (ListView) findViewById(R.id.seasons);
        //Add values to list
        seasonListView.setAdapter(seasonAdapter);

        //Create Item Click Listener
        seasonListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        );

    }
}
