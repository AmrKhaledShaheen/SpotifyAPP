package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Singers_Songs extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        Toast.makeText(this, sessionId, Toast.LENGTH_SHORT).show();
        String nancy="nancy";
        String amr="amr";
        String tamer="tamer";
        String hamaki="hamaki";
        if (sessionId.matches(nancy))
        {
            setContentView(R.layout.nancy_ajram);
            Button play_ELOMR=(Button)findViewById(R.id.play_ELOMR);
            Button play_LYA=(Button)findViewById(R.id.play_LYA);
            play_ELOMR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  EL OMR");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });
            play_LYA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  LYA");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });
        }
        if(sessionId.matches(amr))
        {
            setContentView(R.layout.amr_diab);
            Button play_Zaymanty=(Button)findViewById(R.id.play_Zaymanty);
            Button play_Bahebu=(Button)findViewById(R.id.play_Bahebu);
            play_Zaymanty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("songName","  Zaymanty");
            editor.apply();
            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
            startActivity(intent);
                }
            });
            play_Bahebu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  Bahebu");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });
        }
        if(sessionId.matches(tamer))
        {
            setContentView(R.layout.tamer_hosny);
            Button play_Helwelmakan=(Button)findViewById(R.id.play_Helwelmakan);
            Button play_Wantamaaya=(Button)findViewById(R.id.play_Wantamaaya);
            play_Helwelmakan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  Helw elmakan");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });
            play_Wantamaaya.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  Wanta maaya");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });
        }
        if(sessionId.matches(hamaki))
        {
            setContentView(R.layout.mohamed_hamaki);
            Button play_YaSattar=(Button)findViewById(R.id.play_YaSattar);
            Button play_WeA3malEih=(Button)findViewById(R.id.play_WeA3malEih);
            play_YaSattar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  Ya Sattar");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });
            play_WeA3malEih.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("songName","  We A3mal Eih");
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                    startActivity(intent);
                }
            });

        }
    }
}
