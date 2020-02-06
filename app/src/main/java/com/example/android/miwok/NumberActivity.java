package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ArrayList<Word> words = new ArrayList<Word>();     //        String[] words = new String[10];

        words.add(new Word("Um", "One"));
        words.add(new Word("Dois", "Two"));
        words.add(new Word("Três", "Three"));
        words.add(new Word("Quatro", "Four"));
        words.add(new Word("Cinco", "Five"));
        words.add(new Word("Seis", "Six"));
        words.add(new Word("Sete", "Seven"));
        words.add(new Word("Oito", "Eight"));
        words.add(new Word("Nove", "Nine"));
        words.add(new Word("Dez", "Ten"));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

//        LinearLayout numbersFather = (LinearLayout) findViewById(R.id.numbersFather);
//        int i;
//        for (i = 0; i < words.size(); i++){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            numbersFather.addView(wordView);
//        }
    }
}
