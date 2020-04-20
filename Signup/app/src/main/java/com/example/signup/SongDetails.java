package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SongDetails extends AppCompatActivity {
    private boolean isPlayed=false;
    private String songName;
    private ImageView songImageView;
    private TextView songnameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        songImageView=(ImageView) findViewById(R.id.songimageView);
        songnameTextView=(TextView) findViewById(R.id.songnametextView);
        showsongsDetails();
    }
    public void showsongsDetails()
    {
        songName=getIntent().getStringExtra("songName");
        if(songName.equals("  Sugar"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.sugar));
            songnameTextView.setText(songName);
        }
        else if(songName.equals("  Maps")) {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.maps));
            songnameTextView.setText(songName);
        }
    }
    public void play_pause(View view)
    {
       return;
    }
}
