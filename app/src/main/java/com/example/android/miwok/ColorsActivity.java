package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors2);

        final ArrayList<Word> words = new ArrayList<Word>();     //        String[] words = new String[10];

        words.add(new Word("Vermelho", "Red", R.drawable.red, R.drawable.audio, R.raw.red_a));
        words.add(new Word("Verde", "Green", R.drawable.green, R.drawable.audio, R.raw.green_a));
        words.add(new Word("Marrom", "Brown", R.drawable.brown, R.drawable.audio, R.raw.brown_a));
        words.add(new Word("Cinza", "Gray", R.drawable.gray, R.drawable.audio, R.raw.gray_a));
        words.add(new Word("Preto", "Black", R.drawable.black, R.drawable.audio, R.raw.black_a));
        words.add(new Word("Branco", "White", R.drawable.white, R.drawable.audio, R.raw.white_a));
        words.add(new Word("Amarelo", "Yellow", R.drawable.yellow, R.drawable.audio, R.raw.yellow_a));
        words.add(new Word("Rosa", "Pink", R.drawable.pink, R.drawable.audio, R.raw.pink_a));
        words.add(new Word("Azul", "Blue", R.drawable.blue, R.drawable.audio, R.raw.blue_a));
        words.add(new Word("Roxo", "Purple", R.drawable.purple, R.drawable.audio, R.raw.purple_a));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_color);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioId());
                mediaPlayer.start();
            }
        });
    }
}
