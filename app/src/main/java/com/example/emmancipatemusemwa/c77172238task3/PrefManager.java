package com.example.emmancipatemusemwa.c77172238task3;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by emmancipatemusemwa on 24/04/16.
 */


/**
 * Class for Shared Preference
 */
public class PrefManager {

    Context context;


    PrefManager(Context context) {
        this.context = context;
    }

    public void saveScore(int numberOfClicks) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ScoreDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("numberOfClicksString", numberOfClicks);
        editor.commit();
    }

    public int getScore() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ScoreDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("numberOfClicksString", 0);
        //sharedPreferences.getInt("NumberOfClicks", "");
    }




}