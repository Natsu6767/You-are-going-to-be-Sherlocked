package com.mdg_recruitment.mohit.sherlock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Season4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season4);

        //Array of String storing seasons
        String[] episodeArray = {"Episode 1", "Episode 2", "Episode 3"};
        //Array of image id
        Integer[] imageId = {R.drawable.s4e1, R.drawable.s4e2, R.drawable.s4e3};

        ListView season4ListView;
        season4ListView = (ListView) findViewById(R.id.season4);

        //Creates the rwquired adapter
        CustomList season4Adapter = new CustomList(this, episodeArray, imageId);
        season4ListView.setAdapter(season4Adapter);

        //Create Item Click Listener
        season4ListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String episode = String.valueOf(adapterView.getItemAtPosition(i));

                        Intent intent = new Intent(view.getContext(), EpisodeActivity.class);

                        //Checks which episode whas selected and assigns it to MainActivity.EPISODE
                        switch (episode) {
                            case "Episode 1":
                                MainActivity.EPISODE = "Episode 1";
                                startActivity(intent);
                                break;
                            case "Episode 2":
                                MainActivity.EPISODE = "Episode 2";
                                Toast.makeText(Season4Activity.this, "Coming Soon!", Toast.LENGTH_LONG).show();
                                break;
                            case "Episode 3":
                                MainActivity.EPISODE = "Episode 3";
                                Toast.makeText(Season4Activity.this, "Coming Soon!", Toast.LENGTH_LONG).show();
                                break;
                        }


                    }
                }
        );
    }
}
