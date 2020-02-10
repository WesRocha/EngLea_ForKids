package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors2);

        ArrayList<Word> words = new ArrayList<Word>();     //        String[] words = new String[10];

        words.add(new Word("Vermelho", "Red", R.drawable.red, R.drawable.audio));
        words.add(new Word("Verde", "Green", R.drawable.green, R.drawable.audio));
        words.add(new Word("Marrom", "Brown", R.drawable.brown, R.drawable.audio));
        words.add(new Word("Cinza", "Gray", R.drawable.gray, R.drawable.audio));
        words.add(new Word("Preto", "Black", R.drawable.black, R.drawable.audio));
        words.add(new Word("Branco", "White", R.drawable.white, R.drawable.audio));
        words.add(new Word("Amarelo", "Yellow", R.drawable.yellow, R.drawable.audio));
        words.add(new Word("Rosa", "Pink", R.drawable.pink, R.drawable.audio));
        words.add(new Word("Azul", "Blue", R.drawable.blue, R.drawable.audio));
        words.add(new Word("Roxo", "Purple", R.drawable.purple, R.drawable.audio));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_color);
        listView.setAdapter(adapter);
    }
}
