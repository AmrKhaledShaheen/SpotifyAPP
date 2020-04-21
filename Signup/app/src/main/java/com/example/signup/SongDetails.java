package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SongDetails extends AppCompatActivity {
    private boolean isPlaying=false;
    private String songName;
    private ImageView songImageView,play_pause_imageView;
    private TextView songnameTextView,currentsongtimeTextView,songtimeTextView;
    private SeekBar playerSeekBar;
    private Handler handler= new Handler();

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        currentsongtimeTextView=(TextView) findViewById(R.id.currentsongtimeTextView);
        songtimeTextView=(TextView) findViewById(R.id.songtimeTextView);
        playerSeekBar =(SeekBar) findViewById(R.id.playerSeekBar);
        songImageView=(ImageView) findViewById(R.id.songimageView);
        songnameTextView=(TextView) findViewById(R.id.songnametextView);
        play_pause_imageView=(ImageView) findViewById(R.id.play_pause_imageView);
        mediaPlayer=new MediaPlayer();
        playerSeekBar.setMax(100);

        playerSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SeekBar seekBar=(SeekBar) v;
                int playPosition=(mediaPlayer.getDuration()/100)*seekBar.getProgress();
                mediaPlayer.seekTo(playPosition);
                currentsongtimeTextView.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
                return false;
            }
        });
        showsongsDetails();
    }


    private Runnable updater=new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
            long currentDuration=mediaPlayer.getCurrentPosition();
            currentsongtimeTextView.setText(milliSecondsToTimer(currentDuration));
        }
    };
    private void updateSeekBar()
    {
        if(mediaPlayer.isPlaying())
        {
            playerSeekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration() ) *100));
            handler.postDelayed(updater,1000);
        }

    }
    private String milliSecondsToTimer(long milliSeconds)
    {
        int seconds=(int)milliSeconds/1000;
        String timerString= "";
        String secondsString;
        int hours=seconds/(60*60);
        int minutes= (seconds % (60*60) )/60;
        seconds= (seconds % (60*60) )%60;

        if(hours>0)
        {
            timerString=hours+":";
        }
        if(seconds<10)
        {
            secondsString=("0" + seconds);
        }
        else
        {
            secondsString="" + seconds;
        }
        timerString= timerString + minutes + ":" + secondsString;



        return timerString;
    }

    public void showsongsDetails()
    {
        songName=getIntent().getStringExtra("songName");
        //mediaPlayer= MediaPlayer.create(this,R.raw.laugh);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if(songName.equals("  Sugar"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.sugar));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://www.hochmuth.com/mp3/Haydn_Cello_Concerto_D-1.mp3");
        }
        else if(songName.equals("  Maps"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.maps));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://www.hochmuth.com/mp3/Haydn_Cello_Concerto_D-1.mp3");
        }
    }
    public void play_pause(View view)
    {
       if(isPlaying)
       {
           handler.removeCallbacks(updater);
           play_pause_imageView.setImageDrawable(getResources().getDrawable(R.drawable.playbutton));
           mediaPlayer.pause();
           isPlaying=false;
       }
       else
       {
           play_pause_imageView.setImageDrawable(getResources().getDrawable(R.drawable.pausebutton));
           mediaPlayer.start();

           isPlaying=true;
           updateSeekBar();
       }
    }
    private void prepareMediaPlayer(String url)
    {
        try{
             mediaPlayer.setDataSource(url);
             mediaPlayer.prepare();
             songtimeTextView.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        }catch(Exception exception)
        {
            Toast.makeText(this,exception.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
