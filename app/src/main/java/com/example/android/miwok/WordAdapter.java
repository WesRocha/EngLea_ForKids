package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        englishTextView.setText(currentWord.getEnglishTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.portugues_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView image1 = (ImageView) listItemView.findViewById(R.id.image1);
        if (currentWord.hasImage()){
            image1.setImageResource(currentWord.getImage());
            image1.setVisibility(View.VISIBLE);
        }else {
            image1.setVisibility(View.GONE);
        }


        ImageView image2 = (ImageView) listItemView.findViewById(R.id.image2);
        image2.setImageResource(currentWord.getImage2());

        return listItemView;
    }
}
