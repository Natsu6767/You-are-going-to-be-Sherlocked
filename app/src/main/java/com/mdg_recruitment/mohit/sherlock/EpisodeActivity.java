package com.mdg_recruitment.mohit.sherlock;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;

public class EpisodeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    // YouTube player view
    private YouTubePlayerView youTubeView;
    private  YouTubePlayer youTubePlayer;

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

    @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            Config.videoIdSet();

            requestWindowFeature(Window.FEATURE_NO_TITLE);
             getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.activity_episode);

            nameTextView = (TextView) findViewById(R.id.epName);
            ratingsTextView = (TextView) findViewById(R.id.epRating);
            durationTextView = (TextView) findViewById(R.id.epDuration);
            summaryTextView = (TextView) findViewById(R.id.epSummary);
            triviaTextView = (TextView) findViewById(R.id.epTrivia);

            youTubeView = (YouTubePlayerView) findViewById(R.id.epVideo);

            // Initializing video player with developer key
             youTubeView.initialize(Config.DEVELOPER_KEY, this);

            //This part of the code deals with the interaction with the database.
            DataAdapter mDbHelper = new DataAdapter(this);
            mDbHelper.createDatabase();
            mDbHelper.open();

            Cursor cursor = mDbHelper.getData();
                //Retrieves data from cursor and sets it in the corresponding TextViews
                String data = cursor.getString(cursor.getColumnIndex(NAME_COLUMN));
                nameTextView.setText(data);

                data = "" + cursor.getDouble((cursor.getColumnIndex(RATINGS_COLUMN)));
                ratingsTextView.setText(data);

                data = "" + cursor.getInt(cursor.getColumnIndex(DURATION_COLUMN));
                durationTextView.setText(data + " min");

                data = cursor.getString((cursor.getColumnIndex(SUMMARY_COLUMN)));
                summaryTextView.setText(data);

                data = cursor.getString((cursor.getColumnIndex(TRIVIA_COLUMN)));
                triviaTextView.setText(data);

            cursor.close();
            mDbHelper.close();
        }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {

        youTubePlayer = player;

        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.loadVideo(Config.YOUTUBE_VIDEO_CODE);

            // Hiding player controls
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.epVideo);
    }
}

