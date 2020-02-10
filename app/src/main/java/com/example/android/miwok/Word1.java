package com.example.android.miwok;

public class Word1 {

    private String mDefaultTranslation;
    private String mEnglishTranslation;
    private int mImage;
    private int mImage2;

    public Word1(String defaultTranslation, String menglishTranslation, int mimage){
        mDefaultTranslation = defaultTranslation;
        mEnglishTranslation = menglishTranslation;
        mImage = mimage;
    }

    public String getDefaultTranslation(){return mDefaultTranslation;}

    public String getEnglishTranslation(){return mEnglishTranslation;}

    public int getImage(){return mImage;}

}
