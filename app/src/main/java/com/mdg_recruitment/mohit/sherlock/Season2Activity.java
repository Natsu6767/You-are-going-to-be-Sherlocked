package com.mdg_recruitment.mohit.sherlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        //Array of image id
        Integer[] imageId = {R.drawable.s2e1, R.drawable.s2e2, R.drawable.s2e3};

        ListView season2ListView;
        season2ListView=(ListView)findViewById(R.id.season2);

        //Creates the required adapter
        CustomList season2Adapter = new CustomList(this, episodeArray, imageId);
        season2ListView.setAdapter(season2Adapter);

        //Create Item Click Listener
        season2ListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String episode = String.valueOf(adapterView.getItemAtPosition(i));

                        //Checks which episode whas selected and assigns it to MainActivity.EPISODE
                        switch (episode){
                            case "Episode 1" :
                                MainActivity.EPISODE = "Episode 1";
                                break;
                            case "Episode 2" :
                                MainActivity.EPISODE = "Episode 2";
                                break;
                            case "Episode 3" :
                                MainActivity.EPISODE = "Episode 3";
                                break;
                        }

                        Intent intent = new Intent(view.getContext(), EpisodeActivity.class);
                        startActivity(intent);

                    }
                }
        );
    }
}
