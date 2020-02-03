package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ArrayList<String> words = new ArrayList<>();     //        String[] words = new String[10];

        words.add("one");        //        words[0] = "one";
        words.add("two");        //        words[1] = "two";
        words.add("three");      //        words[2] = "three";
        words.add("four");       //        words[3] = "four";
        words.add("five");       //        words[4] = "five";
        words.add("six");        //        words[5] = "six";
        words.add("seven");      //        words[6] = "seven";
        words.add("eight");      //        words[7] = "eight";
        words.add("nine");       //        words[8] = "nine";
        words.add("ten");        //        words[9] = "ten";

        LinearLayout numbersFather = (LinearLayout) findViewById(R.id.numbersFather);
        int i;
        for (i = 0; i < words.size(); i++){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(i));
            numbersFather.addView(wordView);
        }
    }
}
