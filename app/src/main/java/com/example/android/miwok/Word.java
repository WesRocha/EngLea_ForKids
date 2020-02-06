package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mEnglishTranslation;

    public Word(String defaultTranslation, String menglishTranslation){
        mDefaultTranslation = defaultTranslation;
        mEnglishTranslation = menglishTranslation;
    }

    public String getDefaultTranslation(){return mDefaultTranslation;}

    public String getEnglishTranslation(){return mEnglishTranslation;}

}
