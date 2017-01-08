package com.mdg_recruitment.mohit.sherlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //These two variables are used for the SQL query as constraints
    public static String EPISODE = new String();
    public static String SEASON = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array of String storing seasons
        String[] seasonArray = {"Season 1", "Season 2", "Season 3"};
        //Creates ListAdapter to convert String to List items
        StringList seasonAdapter = new StringList(this, seasonArray);
        //Create ListView object
        ListView seasonListView = (ListView) findViewById(R.id.seasons);
        //Add values to list
        seasonListView.setAdapter(seasonAdapter);

        //Create Item Click Listener
        seasonListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String season = String.valueOf(adapterView.getItemAtPosition(i));
                        //Checks which season was selected and thus decides which activity to open
                        switch (season) {
                            case "Season 1":
                                SEASON = "Season 1";
                                Intent intent1 = new Intent(view.getContext(), Season1Activity.class);
                                startActivity(intent1);
                                break;
                            case "Season 2":
                                SEASON = "Season 2";
                                Intent intent2 = new Intent(view.getContext(), Season2Activity.class);
                                startActivity(intent2);
                                break;
                            case "Season 3":
                                SEASON = "Season 3";
                                Intent intent3 = new Intent(view.getContext(), Season3Activity.class);
                                startActivity(intent3);
                                break;
                        }

                    }
                }
        );

    }
}
