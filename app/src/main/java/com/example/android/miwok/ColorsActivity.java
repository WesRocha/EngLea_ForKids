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

        words.add(new Word("Vermelho", "Red", R.drawable.audio));
        words.add(new Word("Verde", "Green", R.drawable.audio));
        words.add(new Word("Marrom", "Brown", R.drawable.audio));
        words.add(new Word("Cinza", "Gray", R.drawable.audio));
        words.add(new Word("Preto", "Black", R.drawable.audio));
        words.add(new Word("Branco", "White", R.drawable.audio));
        words.add(new Word("Amarelo", "Yellow", R.drawable.audio));
        words.add(new Word("Rosa", "Pink", R.drawable.audio));
        words.add(new Word("Blue", "Azul", R.drawable.audio));
        words.add(new Word("Purple", "Roxo", R.drawable.audio));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_color);
        listView.setAdapter(adapter);
    }
}
