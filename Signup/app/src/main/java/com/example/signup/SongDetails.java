package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SongDetails extends AppCompatActivity {
    private boolean isPlaying=false;
    private String songName;
    private ImageView songImageView,play_pause_imageView;
    private TextView songnameTextView;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        songImageView=(ImageView) findViewById(R.id.songimageView);
        songnameTextView=(TextView) findViewById(R.id.songnametextView);
        play_pause_imageView=(ImageView) findViewById(R.id.play_pause_imageView);
        showsongsDetails();
    }
    public void showsongsDetails()
    {
        songName=getIntent().getStringExtra("songName");
        //mediaPlayer= MediaPlayer.create(this,R.raw.laugh);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if(songName.equals("  Sugar"))
        {
            mediaPlayer= MediaPlayer.create(this,R.raw.sugar);
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.sugar));
            songnameTextView.setText(songName);
        }
        else if(songName.equals("  Maps")) {
            mediaPlayer= MediaPlayer.create(this,R.raw.maps);
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.maps));
            songnameTextView.setText(songName);
        }
    }
    public void play_pause(View view)
    {
       if(isPlaying)
       {
           play_pause_imageView.setImageDrawable(getResources().getDrawable(R.drawable.playbutton));
           mediaPlayer.pause();
           isPlaying=false;
       }
       else
       {
           play_pause_imageView.setImageDrawable(getResources().getDrawable(R.drawable.pausebutton));
           mediaPlayer.start();
           isPlaying=true;
       }
    }
}
