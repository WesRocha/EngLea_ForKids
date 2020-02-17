package com.example.android.miwok;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        final ArrayList<Word> words = new ArrayList<Word>();     //        String[] words = new String[10];

        words.add(new Word("Um", "One", R.drawable.one, R.drawable.audio, R.raw.one_a));
        words.add(new Word("Dois", "Two", R.drawable.two, R.drawable.audio, R.raw.two_a));
        words.add(new Word("Três", "Three", R.drawable.three, R.drawable.audio, R.raw.three_a));
        words.add(new Word("Quatro", "Four", R.drawable.four, R.drawable.audio, R.raw.four_a));
        words.add(new Word("Cinco", "Five", R.drawable.five, R.drawable.audio, R.raw.five_a));
        words.add(new Word("Seis", "Six", R.drawable.six, R.drawable.audio, R.raw.six_a));
        words.add(new Word("Sete", "Seven", R.drawable.seven, R.drawable.audio, R.raw.seven_a));
        words.add(new Word("Oito", "Eight", R.drawable.eight, R.drawable.audio, R.raw.eight_a));
        words.add(new Word("Nove", "Nine", R.drawable.nine, R.drawable.audio, R.raw.nine_a));
        words.add(new Word("Dez", "Ten", R.drawable.ten, R.drawable.audio, R.raw.ten_a));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_number);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(NumberActivity.this, word.getmAudioId());
                mediaPlayer.start();
            }
        });

//        LinearLayout numbersFather = (LinearLayout) findViewById(R.id.numbersFather);
//        int i;
//        for (i = 0; i < words.size(); i++){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            numbersFather.addView(wordView);
//        }
    }
}
