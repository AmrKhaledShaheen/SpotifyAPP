package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaylistDetails extends AppCompatActivity {
    private Button addSongs;
    private TextView playlistName;
    private LinearLayout songslinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_details);
        addSongs=(Button) findViewById(R.id.addSongsButton);
        playlistName=(TextView) findViewById(R.id.playlistTextView);
        songslinearLayout=(LinearLayout) findViewById(R.id.playlistsongsLinearLayout);


    }
    public void goToAllSongs(View view)
    {
        Intent intent=new Intent(this, AllSongs.class);
        startActivity(intent);
    }
}
