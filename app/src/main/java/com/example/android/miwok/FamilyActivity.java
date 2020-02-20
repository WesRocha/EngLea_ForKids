package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_family2);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Pai", "Father", R.drawable.father, R.drawable.audio, R.raw.father_a));
        words.add(new Word("Mãe", "Mother", R.drawable.mother, R.drawable.audio, R.raw.mother_a));
        words.add(new Word("Filho", "Son", R.drawable.son, R.drawable.audio, R.raw.son_a));
        words.add(new Word("Filha", "Daughter", R.drawable.daughter, R.drawable.audio, R.raw.daughter_a));
        words.add(new Word("Irmão mais velho", "Older brother", R.drawable.older_brother, R.drawable.audio, R.raw.older_brother_a));
        words.add(new Word("Irmão mais novo", "Younger brother", R.drawable.younger_brother, R.drawable.audio, R.raw.younger_brother_a));
        words.add(new Word("Irmã mais velha", "Older sister", R.drawable.older_sister, R.drawable.audio, R.raw.older_sister_a));
        words.add(new Word("Irmã mais nova", "Younger sister", R.drawable.younger_sister, R.drawable.audio, R.raw.younger_sister_a));
        words.add(new Word("Avó", "Grandmother", R.drawable.grandmother, R.drawable.audio, R.raw.grandmother_a));
        words.add(new Word("Avô", "Grandfather", R.drawable.grandfather, R.drawable.audio, R.raw.grandfather_a));

        WordAdapter adapter1 = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list_family);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Word word = words.get(i);

            releaseMediaPlayer();

            int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioId());
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
