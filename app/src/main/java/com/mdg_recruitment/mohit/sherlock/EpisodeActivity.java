package com.mdg_recruitment.mohit.sherlock;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class EpisodeActivity extends AppCompatActivity {

        //Declaring column names of the table in the database
        final static String ID_COLUMN = "id";
        final static String SEASON_COLUMN = "season";
        final static String EPISODE_COLUMN = "episode";
        final String NAME_COLUMN = "name";
        final String DURATION_COLUMN = "duration";
        final String RATINGS_COLUMN = "ratings";
        final String SUMMARY_COLUMN = "summary";
        final String TRIVIA_COLUMN = "trivia";

        TextView nameTextView, ratingsTextView, durationTextView, summaryTextView, triviaTextView;
        //ImageView picImageView;
        ProgressDialog pDialog;
        VideoView trailerVideoView;

        String videoURL = "http://www.ted.com/talks/download/video/8584/talk/761";

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_episode);

            nameTextView = (TextView) findViewById(R.id.epName);
            ratingsTextView = (TextView) findViewById(R.id.epRating);
            durationTextView = (TextView) findViewById(R.id.epDuration);
            summaryTextView = (TextView) findViewById(R.id.epSummary);
            triviaTextView = (TextView) findViewById(R.id.epTrivia);
            //picImageView = (ImageView) findViewById(R.id.epImage);
            trailerVideoView = (VideoView) findViewById(R.id.epVideo);


            DataAdapter mDbHelper = new DataAdapter(this);
            mDbHelper.createDatabase();
            mDbHelper.open();

            Cursor cursor = mDbHelper.getData();

                //Retrieves data from cursor and sets it in the corresponding TextViews
                String data = cursor.getString(cursor.getColumnIndex(NAME_COLUMN));
                nameTextView.setText(data);

                data = "" + cursor.getDouble((cursor.getColumnIndex(RATINGS_COLUMN)));
                ratingsTextView.setText(data + " / 10");

                data = "" + cursor.getInt(cursor.getColumnIndex(DURATION_COLUMN));
                durationTextView.setText(data + " min");

                data = cursor.getString((cursor.getColumnIndex(SUMMARY_COLUMN)));
                summaryTextView.setText(data);

                data = cursor.getString((cursor.getColumnIndex(TRIVIA_COLUMN)));
                triviaTextView.setText(data);




            cursor.close();

            mDbHelper.close();


            trailerVideoView.setVideoPath(videoURL);

            MediaController videoControls = new MediaController(this);
            videoControls.setAnchorView(trailerVideoView);
            trailerVideoView.setMediaController(videoControls);


        }



    }

