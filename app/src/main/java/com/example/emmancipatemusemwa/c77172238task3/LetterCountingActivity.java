package com.example.emmancipatemusemwa.c77172238task3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LetterCountingActivity extends AppCompatActivity {

    Context context;
    EditText EditTextInput;
    String strInput;
    Button checkBtn;
    TextView txtLenght;
    TextView resultV;
    int currentScore;
    int numberOfClicks;
    String numberOfClicksString;
    String numberOfScoresString;
    SharedPreferences sharedPreferences;
    TextView welcomeTextView;

    String[] names = new String[]{
            "Eman",
            "Emmancipate",
            "Peter",
            "Ivy",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_counting);

        Bundle extras = getIntent().getExtras();
        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        welcomeTextView.setText(extras.getString("Message"));



        sharedPreferences = getSharedPreferences("ScoreDetails", MODE_PRIVATE);

        //initializae Views
        checkBtn = (Button) findViewById(R.id.checkBtn);
        EditTextInput = (EditText) findViewById(R.id.editText);
        txtLenght = (TextView) findViewById(R.id.nameView);
        resultV = (TextView) findViewById(R.id.resultView);

        //Randomize name from  array
        Random random = new Random();
        txtLenght.setText(names[random.nextInt(3)]);

        //initialize variables


        //Number of Clicks or/ Attempts
        numberOfClicksString = getString(R.string.number_of_clicks);
        numberOfClicks = sharedPreferences.getInt(numberOfClicksString, 0);


        //Number of correct Scores
        numberOfScoresString = getString(R.string.number_of_scores);
        currentScore = sharedPreferences.getInt(numberOfScoresString, 0);


        checkBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int length = Integer.parseInt(EditTextInput.getText().toString());
                numberOfClicks++;
                if (length == txtLenght.getText().toString().length()) {
                    currentScore++;
                    //Toast.makeText(getApplicationContext(), "Your Guess is correct", Toast.LENGTH_LONG).show();
                    resultV.setText("Good Guess, That's correct");

                } else {
                    //Toast.makeText(getApplicationContext(), "Your Guess is wrong!!!", Toast.LENGTH_LONG).show();
                    resultV.setText("Wrong Guess, Try Again");
                }


            }

            ;
        });

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

    /**
     * @Override protected void onPause () {
     * super.onPause();
     * <p/>
     * SharedPreferences sharedPreferences = getSharedPreferences("ScoreDetails", Context.MODE_PRIVATE);
     * SharedPreferences.Editor editor = sharedPreferences.edit();
     * editor.putString("numberOfClicksString", EditTextInput.getText().toString());
     * editor.commit();
     * }
     **/

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putInt(numberOfClicksString, numberOfClicks).commit();
        sharedPreferences.edit().putInt(numberOfScoresString, currentScore).commit();
    }


}
