package com.mdg_recruitment.mohit.sherlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Season3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season3);

        //Array of String storing seasons
        String[] episodeArray = {"Episode 1", "Episode 2", "Episode 3"};
        //Array of image id
        Integer[] imageId = {R.drawable.s3e1, R.drawable.s3e2, R.drawable.s3e3};

        ListView season3ListView;
        season3ListView=(ListView)findViewById(R.id.season3);

        //Creates the rwquired adapter
        CustomList season3Adapter = new CustomList(this, episodeArray, imageId);
        season3ListView.setAdapter(season3Adapter);

        //Create Item Click Listener
        season3ListView.setOnItemClickListener(
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
