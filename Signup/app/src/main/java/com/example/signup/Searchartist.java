package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Searchartist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchartist);
    }

    public void backToChooseArtist(View view)
    {
        Intent intent=new Intent(this, ChooseArtist.class);
        startActivity(intent);
    }
}
