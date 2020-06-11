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

/**
 * This is activity shows Song Details - its time - name - display picture
 * playing songs, i used this link https://www.youtube.com/watch?v=QVI7NUvMgXU
 * @version 1.0
 */
public class SongDetails extends AppCompatActivity {
    private boolean isPlaying=false;
    private String songName;
    private ImageView songImageView,play_pause_imageView;
    private TextView songnameTextView,currentsongtimeTextView,songtimeTextView;
    private SeekBar playerSeekBar;
    private SeekBar volumeSeekBar;
    private Handler handler= new Handler();
    private String song_url;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int maxVolume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        currentsongtimeTextView=(TextView) findViewById(R.id.currentsongtimeTextView);
        songtimeTextView=(TextView) findViewById(R.id.songtimeTextView);
        playerSeekBar =(SeekBar) findViewById(R.id.playerSeekBar);
        volumeSeekBar =(SeekBar) findViewById(R.id.volumeSeekBar);
        songImageView=(ImageView) findViewById(R.id.songimageView);
        songnameTextView=(TextView) findViewById(R.id.songnametextView);
        play_pause_imageView=(ImageView) findViewById(R.id.play_pause_imageView);
        mediaPlayer=MySingleton.getInstance();

        playerSeekBar.setMax(100);
        volumeSeekBar.setMax(100);
        volumeSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SeekBar seekBar=(SeekBar) v;

                float volume=(float)seekBar.getProgress()/100;
                System.out.println(volume);
                if(mediaPlayer!=null) {
                    mediaPlayer.setVolume(volume,volume);
                }
                return false;
            }
        });
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
                mp.start();
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
    /**
     * updates seekbar with real time of mediaplayer for the played song
     */
    private void updateSeekBar()
    {
        if(mediaPlayer.isPlaying())
        {
            playerSeekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration() ) *100));
            handler.postDelayed(updater,1000);
        }

    }
    /**
     * converts time of song to mins/secs/hours
     */
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
    /**
     * shows name of song - picture of song - sets mediaplayer with link of selected song
     */
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
    /**
     * responsible for changing icon which shows wether song is playing or paused
     */
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
    /**
     * prepare mediaplayer with link
     * @param url sets mediaplayer with a certain song
     */
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

            songtimeTextView.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        }catch(Exception exception)
        {
            Toast.makeText(this,exception.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * plays next song
     */
    public void next(View v)
    {
        String name=sharedPreferences.getString("songName","not found");
        if(name.equals("  Sugar"))
        {
            editor.putString("songName","  Maps");
        }
        else if(name.equals("  Maps"))
        {
            editor.putString("songName","  Zaymanty");
        }
        else if(name.equals("  Zaymanty"))
        {
            editor.putString("songName","  Bahebu");
        }
        else if(name.equals("  Bahebu"))
        {
            editor.putString("songName","  Wanta maaya");
        }
        else if(name.equals("  Wanta maaya"))
        {
            editor.putString("songName","  Helw elmakan");
        }
        else if(name.equals("  Helw elmakan"))
        {
            editor.putString("songName","  LYA");
        }
        else if(name.equals("  LYA"))
        {
            editor.putString("songName","  EL OMR");
        }
        else if(name.equals("  EL OMR"))
        {
            editor.putString("songName","  Ya Sattar");
        }
        else if(name.equals("  Ya Sattar"))
        {
            editor.putString("songName","  We A3mal Eih");
        }
        else if(name.equals("  We A3mal Eih"))
        {
            editor.putString("songName","  Sugar");
        }
        editor.apply();
        showsongsDetails();
        mediaPlayer.start();

    }
    /**
     * plays previous song
     */
    public void previous(View v)
    {
        String name=sharedPreferences.getString("songName","not found");
        if(name.equals("  Sugar"))
        {
            editor.putString("songName","  We A3mal Eih");
        }
        else if(name.equals("  Maps"))
        {
            editor.putString("songName","  Sugar");
        }
        else if(name.equals("  Zaymanty"))
        {
            editor.putString("songName","  Maps");
        }
        else if(name.equals("  Bahebu"))
        {
            editor.putString("songName","  Zaymanty");
        }
        else if(name.equals("  Wanta maaya"))
        {
            editor.putString("songName","  Bahebu");
        }
        else if(name.equals("  Helw elmakan"))
        {
            editor.putString("songName","  Wanta maaya");
        }
        else if(name.equals("  LYA"))
        {
            editor.putString("songName","  Helw elmakan");
        }
        else if(name.equals("  EL OMR"))
        {
            editor.putString("songName","  LYA");
        }
        else if(name.equals("  Ya Sattar"))
        {
            editor.putString("songName","  EL OMR");
        }
        else if(name.equals("  We A3mal Eih"))
        {
            editor.putString("songName","  Sugar");
        }
        editor.apply();
        showsongsDetails();
        mediaPlayer.start();
    }
}
