package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases2);

        ArrayList<Word1> words = new ArrayList<Word1>();     //        String[] words = new String[10];

        words.add(new Word1("Onde você vai?", "Where are you going?", R.drawable.audio));
        words.add(new Word1("Qual é o seu nome?", "What is your name?", R.drawable.audio));
        words.add(new Word1("Meu nome é...", "My name is...", R.drawable.audio));
        words.add(new Word1("Como você está se sentindo?", "How are you feeling?", R.drawable.audio));
        words.add(new Word1("Eu estou me sentindo bem", "I’m feeling good", R.drawable.audio));
        words.add(new Word1("Você está vindo?", "Are you coming?", R.drawable.audio));
        words.add(new Word1("Estou indo sim", "Yes, I’m coming", R.drawable.audio));
        words.add(new Word1("I’m coming", "Estou chegando", R.drawable.audio));
        words.add(new Word1("Let’s go", "Vamos", R.drawable.audio));
        words.add(new Word1("Venha aqui", "Come here", R.drawable.audio));

        Word1Adapter adapter = new Word1Adapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_phrases);
        listView.setAdapter(adapter);
    }
}
