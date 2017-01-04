package com.mdg_recruitment.mohit.sherlock;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

public class DataAdapter
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    public DataAdapter(Context context)  //Contructor
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter open() throws SQLException
    {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();

        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public Cursor getData() //Function to retrieve data from inside the table in the database
    {
            //The SQL query which gives the required data result. episodedesc is the table name inside the database sherlock
            String sql ="SELECT * FROM episodedesc WHERE " + EpisodeActivity.SEASON_COLUMN + " = \"" + MainActivity.SEASON + "\" AND " + EpisodeActivity.EPISODE_COLUMN + " = \"" + MainActivity.EPISODE + "\";";

            Cursor mCur = mDb.rawQuery(sql, null);
            mCur.moveToFirst();
            return mCur;

    }
}
