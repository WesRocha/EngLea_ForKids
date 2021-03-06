package com.example.android.miwok;
import android.content.Context;
import android.media.AudioManager;
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

    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener(){
        public void onAudioFocusChange(int focusChange){
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

            releaseMediaPlayer();

            int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mediaPlayer = MediaPlayer.create(NumberActivity.this, word.getmAudioId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
