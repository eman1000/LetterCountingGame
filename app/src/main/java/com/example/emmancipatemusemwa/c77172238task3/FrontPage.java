package com.example.emmancipatemusemwa.c77172238task3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrontPage extends AppCompatActivity {


    public static final int DEFAULT = 0;
    TextView scoreView;
    EditText playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        playerName = (EditText) findViewById(R.id.playerNameText);


        scoreView = (TextView) findViewById(R.id.scoreView);
        SharedPreferences sharedPreferences = getSharedPreferences("ScoreDetails", MODE_PRIVATE);

        //Get Total Attempts/ Clicks
        String numberOfClicksString = getString(R.string.number_of_clicks);
        int numberOfClicks = sharedPreferences.getInt(numberOfClicksString, 0);

        //Get Total Correct Guesses
        String numberOfScoresString = getString(R.string.number_of_scores);
        int currentScore = sharedPreferences.getInt(numberOfScoresString, 0);

        scoreView.setText(""+currentScore+"/" +numberOfClicks);






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        scoreView = (TextView) findViewById(R.id.scoreView);
        SharedPreferences sharedPreferences = getSharedPreferences("ScoreDetails", MODE_PRIVATE);
        //Get Total Attempts/ Clicks
        String numberOfClicksString = getString(R.string.number_of_clicks);
        int numberOfClicks = sharedPreferences.getInt(numberOfClicksString, 0);

        //Get Total Correct Guesses
        String numberOfScoresString = getString(R.string.number_of_scores);
        int currentScore = sharedPreferences.getInt(numberOfScoresString, 0);

        scoreView.setText(""+currentScore+"/" +numberOfClicks);

    }

    // public void load(View view){

       // SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
       // String name = sharedPreferences.getString("name", DEFAULT);

       // if(name.equals(DEFAULT)) {

        //    Toast.makeText(this, "No Data", Toast.LENGTH_LONG).show();

       // }
       // else {

          //  Toast.makeText(this, "No Data loaded", Toast.LENGTH_LONG).show();
          //  scoreView.setText(name);

        //}


    //}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_letter_counting) {

            Intent intent = new Intent(this, LetterCountingActivity.class);
            intent.putExtra("Message","Welcome " +playerName.getText().toString()+" to my counting game I will pick a random name, how many letters are in it?");
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
