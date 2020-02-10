package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;
    private String mEnglishTranslation;
    private int mImage;
    private int mImage2;

    public Word(String defaultTranslation, String menglishTranslation, int mimage, int mimage2){
        mDefaultTranslation = defaultTranslation;
        mEnglishTranslation = menglishTranslation;
        mImage = mimage;
        mImage2 = mimage2;
    }

    public String getDefaultTranslation(){return mDefaultTranslation;}

    public String getEnglishTranslation(){return mEnglishTranslation;}

    public int getImage(){return mImage;}

    public int getImage2(){return mImage2;}
}
