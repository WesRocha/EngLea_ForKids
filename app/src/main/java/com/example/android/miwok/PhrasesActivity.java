package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases2);

        final ArrayList<Word> words = new ArrayList<Word>();     //        String[] words = new String[10];

        words.add(new Word("Onde você vai?", "Where are you going?", R.drawable.audio, R.raw.phrase1));
        words.add(new Word("Qual é o seu nome?", "What is your name?", R.drawable.audio, R.raw.phrase2));
        words.add(new Word("Meu nome é...", "My name is...", R.drawable.audio, R.raw.phrase3));
        words.add(new Word("Como você está se sentindo?", "How are you feeling?", R.drawable.audio, R.raw.phrase4));
        words.add(new Word("Eu estou me sentindo bem", "I’m feeling good", R.drawable.audio, R.raw.phrase5));
        words.add(new Word("Você está vindo?", "Are you coming?", R.drawable.audio, R.raw.phrase6));
        words.add(new Word("Sim, estou indo", "Yes, I’m coming", R.drawable.audio, R.raw.phrase7));
        words.add(new Word("Estou chegando", "I’m coming", R.drawable.audio, R.raw.phrase8));
        words.add(new Word("Vamos", "Let’s go", R.drawable.audio, R.raw.phrase9));
        words.add(new Word("Venha aqui", "Come here", R.drawable.audio, R.raw.phrase10));

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_phrases);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);
                MediaPlayer mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioId());
                mediaPlayer.start();
            }
        });
    }

    private void releaseMediaPlayer(){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
