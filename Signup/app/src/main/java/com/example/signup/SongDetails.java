package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
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
    private String song_url;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
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
        mediaPlayer=MySingleton.getInstance();
        playerSeekBar.setMax(100);
        final String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
        sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
        editor=sharedPreferences.edit();
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
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //mp.seekTo(1);
                prepareMediaPlayer(song_url);
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
        //songName=getIntent().getStringExtra("songName");
        songName=sharedPreferences.getString("songName","not found");
        editor.putString("currentSong",songName).apply();
        //mediaPlayer= MediaPlayer.create(this,R.raw.laugh);
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if(songName.equals("  Sugar"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.sugar));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
        }
        else if(songName.equals("  Maps"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.maps));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
        }
        else if(songName.equals("  Zaymanty"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.zaymanty));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
        }
        else if(songName.equals("  Bahebu"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.bahebu));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/13-Bahebo.mp3");
        }
        else if(songName.equals("  Wanta maaya"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.wantamaaya));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/2020/May/Tamer.Hosny.Cheb.Khaled.%20Wa.enta%20.Maayia.mp3");
        }
        else if(songName.equals("  Helw elmakan"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.helwelmakan));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/2019/Dec/Tamer.Hosny.Helw.El.Makan.mp3");
        }
        else if(songName.equals("  LYA"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.lya));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/2019/Feb/Aghanyna.CoM-Nancy.Ajram.Lya.mp3");
        }
        else if(songName.equals("  EL OMR"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.elomr));
            songnameTextView.setText(songName);
            prepareMediaPlayer("http://music.egonair.com/2020/Apr/Nancy.Ajram.El.Omr.mp3");
        }
        else if(songName.equals("  Ya Sattar"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.yasattar));
            songnameTextView.setText(songName);
            prepareMediaPlayer("https://www.aghanyna.com/arabic/wp-content/uploads/2019/01/Ya.Star_.mp3");
        }
        else if(songName.equals("  We A3mal Eih"))
        {
            songImageView.setImageDrawable(getResources().getDrawable(R.drawable.wea3maleh));
            songnameTextView.setText(songName);
            prepareMediaPlayer("https://www.aghanyna.com/arabic/wp-content/uploads/2019/01/Wa3ml.Eyh_.mp3");
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
            song_url=url;
            System.out.println("Trueeeeeee");
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
             mediaPlayer.setDataSource(url);
             mediaPlayer.prepare();
             mediaPlayer.start();
             songtimeTextView.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        }catch(Exception exception)
        {
            Toast.makeText(this,exception.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
