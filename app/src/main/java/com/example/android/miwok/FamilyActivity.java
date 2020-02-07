package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family2);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Pai", "Father", R.drawable.audio));
        words.add(new Word("Mãe", "Mother", R.drawable.audio));
        words.add(new Word("Filho", "Son", R.drawable.audio));
        words.add(new Word("Filha", "Daughter", R.drawable.audio));
        words.add(new Word("Irmão mais velho", "Older brother", R.drawable.audio));
        words.add(new Word("Irmão mais novo", "Younger brother", R.drawable.audio));
        words.add(new Word("Irmã mais velha", "Older sister", R.drawable.audio));
        words.add(new Word("Irmã mais nova", "Younger sister", R.drawable.audio));
        words.add(new Word("Avó", "Grandmother", R.drawable.audio));
        words.add(new Word("Avõ", "Grandfather", R.drawable.audio));

        WordAdapter adapter1 = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_family);
        listView.setAdapter(adapter1);
    }
}
