package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Artist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent(R.layout.activity_artist);
    }


    public void setContent(int id)
    {
        setContentView(id);

    }
    public void goSearch(View view)
    {
        setContent(R.layout.activity_search);
    }
    public void backToArtist(View view)
    {
        setContent(R.layout.activity_artist);
    }





}
