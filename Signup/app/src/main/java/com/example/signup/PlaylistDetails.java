package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity responsible for showing playlist information - name of playlist - liked songs
 * @version 1.0
 */

public class PlaylistDetails extends AppCompatActivity {
    /**
     * Button variable used to open all songs for user to choose from it which to be added in playlist he created
     */
    private Button addSongs;
    /**
     * responsible for showing name of playlist
     */
    private TextView playlistNameTextView;
    /**
     * LinearLayout variable used to show all songs chosen by user
     */
    private LinearLayout songslinearLayout;
    private String playlistName;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    /**
     * Integer variable indicates number of songs in playlist
     */
    private int songs_number;
    /**
     * MediaPlayer variable used to play/pause song
     */
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    private Button playbar;
    private boolean isPlaying = false;
    private Drawable img,img2;
    private ImageView imageView;
    private int currentSec;
    /**
     * String variable used shows which song is playing
     */
    private String current_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_playlist_details);

        String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
        sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        playbar = (Button) findViewById(R.id.playbarButton);
        addSongs = (Button) findViewById(R.id.addSongsButton);
        playlistNameTextView = (TextView) findViewById(R.id.playlistTextView);
        songslinearLayout = (LinearLayout) findViewById(R.id.playlistsongsLinearLayout);
        imageView=(ImageView) findViewById(R.id.play_pause_imageView);
        mediaPlayer=MySingleton.getInstance();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                prepareMediaPlayer(current_url);
                mp.start();
            }
        });
        loadData();

    }
    /**
     * loads data in sharedpreferences
     */
    public void loadData() {
        boolean isVisible=sharedPreferences.getBoolean("isVisible",false);
        boolean Playing=sharedPreferences.getBoolean("isPlaying",false);
        //boolean isPlaying=sharedPreferences.getBoolean("isPlaying",false);
        String url=sharedPreferences.getString("song_url","not found");
        System.out.println(Playing);
        System.out.println(isVisible);
        if(isVisible==true)
        {
            String songName=sharedPreferences.getString("currentSong","not found");
            Drawable image1=null;
            Drawable image2=null;
            System.out.println(songName);
            imageView.setVisibility(View.VISIBLE);
            playbar.setVisibility(View.VISIBLE);
            playbar.setText(songName);
            if(Playing)
            {
                isPlaying=true;
                imageView.setImageResource(R.drawable.pause_red);
                image1=getResources().getDrawable(R.drawable.pause_white);

            }
            else
            {
                isPlaying=false;
                imageView.setImageResource(R.drawable.play_red);
                image1=getResources().getDrawable(R.drawable.play_white);
            }
            if (songName.equals("  sugar")) {

                image2 = getResources().getDrawable(R.drawable.sugar);
            } else if (songName.equals("  maps")) {

                image2 = getResources().getDrawable(R.drawable.maps);
            } else if (songName.equals("  Wanta maaya")) {

                image2 = getResources().getDrawable(R.drawable.wantamaaya);
            } else if (songName.equals("  Helw elmakan")) {

                image2 = getResources().getDrawable(R.drawable.helwelmakan);
            } else if (songName.equals("  LYA")) {

                image2 = getResources().getDrawable(R.drawable.lya);
            } else if (songName.equals("  EL OMR")) {

                image2 = getResources().getDrawable(R.drawable.elomr);
            } else if (songName.equals("  Ya Sattar")) {

                image2 = getResources().getDrawable(R.drawable.yasattar);
            } else if (songName.equals("  We A3mal Eih")) {

                image2 = getResources().getDrawable(R.drawable.wea3maleh);
            } else if (songName.equals("  Zaymanty")) {

                image2 = getResources().getDrawable(R.drawable.zaymanty);
            } else if (songName.equals("  bahebu")) {

                image2 = getResources().getDrawable(R.drawable.bahebu);
            }
            image2.setBounds(0, 0, 200, 200);
            img=image2;
            image1.setBounds(0,0,140,140);
            playbar.setCompoundDrawables(image2,null,image1,null);
        }

        //currentSec=sharedPreferences.getInt("currentSec",0);
        if(url.equals("not found"))
            System.out.println("3eeeeeeeeB");
        else
            System.out.println("3eeeeeeeeB222");
            //prepareMediaPlayer(url);
        playlistName = sharedPreferences.getString("playlistName", "not found");
        playlistNameTextView.setText(playlistName);
        songs_number = sharedPreferences.getInt(playlistName + "count", 0);
        if(songs_number>0)
            imageView.setVisibility(View.VISIBLE);
        else
            imageView.setVisibility(View.INVISIBLE);
        System.out.println("songs_number= " + songs_number);
        LinearLayout.LayoutParams k = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0, 30, 0, 0);
        for (int i = 0; i < songs_number; i++) {
            Button button = new Button(this);
            int count = i + 1;
            Drawable img3=null;
            String songName = sharedPreferences.getString(playlistName + count, "not found");
            System.out.println(songName);
            if (songName.equals("  sugar")) {
                button.setText("  Sugar");
                img3 = getResources().getDrawable(R.drawable.sugar);
            } else if (songName.equals("  maps")) {
                button.setText("  Maps");
                img3 = getResources().getDrawable(R.drawable.maps);
            } else if (songName.equals("  Wanta maaya")) {
                button.setText("  Wanta maaya");
                img3 = getResources().getDrawable(R.drawable.wantamaaya);
            } else if (songName.equals("  Helw elmakan")) {
                button.setText("  Helw elmakan");
                img3 = getResources().getDrawable(R.drawable.helwelmakan);
            } else if (songName.equals("  LYA")) {
                button.setText("  LYA");
                img3 = getResources().getDrawable(R.drawable.lya);
            } else if (songName.equals("  EL OMR")) {
                button.setText("  EL OMR");
                img3 = getResources().getDrawable(R.drawable.elomr);
            } else if (songName.equals("  Ya Sattar")) {
                button.setText("  Ya Sattar");
                img3 = getResources().getDrawable(R.drawable.yasattar);
            } else if (songName.equals("  We A3mal Eih")) {
                button.setText("  We A3mal Eih");
                img3 = getResources().getDrawable(R.drawable.wea3maleh);
            } else if (songName.equals("  zaymanty")) {
                button.setText("  Zaymanty");
                img3 = getResources().getDrawable(R.drawable.zaymanty);
            } else if (songName.equals("  bahebu")) {
                button.setText("  Bahebu");
                img3 = getResources().getDrawable(R.drawable.bahebu);
            } else
                break;
            img3.setBounds(0, 0, 200, 200);
            button.setTextSize(22);
            button.setPadding(40, 0, 0, 0);
            button.setAllCaps(false);

            button.setBackgroundColor(Color.BLACK);
            button.setCompoundDrawables(img3, null, null, null);
            button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opensongDetails(v);
                }
            });
            songslinearLayout.addView(button, k);
        }
    }
    /**
     * opens SongDetails activity to play song
     * @see SongDetails
     */
    public void opensongDetails(View view) {
        Button btn = (Button) view;
        String songName = btn.getText().toString();
        System.out.println(songName);
        editor.putString("songName", songName);
        editor.putBoolean("isPlaying",false);
        editor.apply();

        Intent intent = new Intent(this, SongDetails.class);
        intent.putExtra("songName", songName);

        startActivity(intent);

    }
    /**
     * opens AllSongs activity to choose songs
     * @see AllSongs
     */
    public void goToAllSongs(View view) {
        Intent intent = new Intent(this, AllSongs.class);
        startActivity(intent);
    }
    /**
     * opens HomePage activity
     * @see HomePage
     */
    public void goHome(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    /**
     * open Searchartist activity
     * @see Searchartist
     */
    public void goSearch(View view) {
        //Intent intent = new Intent(this,Logout.class);
        //startActivity(intent);
    }

    /**
     * open Library activity
     * @see Library
     */
    public void goLibrary(View view) {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }
    /**
     * open Premiumm activity
     * @see Premiumm
     */
    public void goPremium(View view) {
        Intent intent = new Intent(this, Premiumm.class);
        startActivity(intent);
    }

    /**
     * shows playbar of played song
     */
    public void show_playbar(View view) {

        if (playbar.getVisibility() == View.INVISIBLE) {
            System.out.println(playbar);
            img = null;
            img2 = null;
            //playbar=(Button) findViewById(R.id.playbarButton);
            if (songs_number > 0) {

                String songName = sharedPreferences.getString(playlistName + songs_number, "not found");
                if (songName.equals("  sugar")) {
                    playbar.setText("  Sugar");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
                    img = getResources().getDrawable(R.drawable.sugar);
                } else if (songName.equals("  maps")) {
                    playbar.setText("  Maps");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
                    img = getResources().getDrawable(R.drawable.maps);
                } else if (songName.equals("  Wanta maaya")) {
                    playbar.setText("  Wanta maaya");
                    prepareMediaPlayer("http://music.egonair.com/2020/May/Tamer.Hosny.Cheb.Khaled.%20Wa.enta%20.Maayia.mp3");
                    img = getResources().getDrawable(R.drawable.wantamaaya);
                } else if (songName.equals("  Helw elmakan")) {
                    playbar.setText("  Helw elmakan");
                    prepareMediaPlayer("http://music.egonair.com/2019/Dec/Tamer.Hosny.Helw.El.Makan.mp3");
                    img = getResources().getDrawable(R.drawable.helwelmakan);

                } else if (songName.equals("  LYA")) {
                    playbar.setText("  LYA");
                    prepareMediaPlayer("http://music.egonair.com/2019/Feb/Aghanyna.CoM-Nancy.Ajram.Lya.mp3");
                    img = getResources().getDrawable(R.drawable.lya);
                } else if (songName.equals("  EL OMR")) {
                    playbar.setText("  EL OMR");
                    prepareMediaPlayer("http://music.egonair.com/2020/Apr/Nancy.Ajram.El.Omr.mp3");
                    img = getResources().getDrawable(R.drawable.elomr);
                } else if (songName.equals("  Ya Sattar")) {
                    playbar.setText("  Ya Sattar");
                    prepareMediaPlayer("https://www.aghanyna.com/arabic/wp-content/uploads/2019/01/Ya.Star_.mp3");
                    img = getResources().getDrawable(R.drawable.yasattar);
                } else if (songName.equals("  We A3mal Eih")) {
                    playbar.setText("  We A3mal Eih");
                    prepareMediaPlayer("https://www.aghanyna.com/arabic/wp-content/uploads/2019/01/Wa3ml.Eyh_.mp3");
                    img = getResources().getDrawable(R.drawable.wea3maleh);
                } else if (songName.equals("  zaymanty")) {
                    playbar.setText("  Zaymanty");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
                    img = getResources().getDrawable(R.drawable.zaymanty);
                } else if (songName.equals("  bahebu")) {
                    playbar.setText("  Bahebu");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/13-Bahebo.mp3");
                    img = getResources().getDrawable(R.drawable.bahebu);
                } else
                    return;
                editor.putString("currentSong",songName).apply();

                img.setBounds(0, 0, 150, 150);
                imageView.setImageResource(R.drawable.pause_red);
                img2 = getResources().getDrawable(R.drawable.pause_white);
                img2.setBounds(0, 0, 140, 140);
                playbar.setCompoundDrawables(img, null, img2, null);
                isPlaying=true;
                mediaPlayer.start();
                playbar.setVisibility(View.VISIBLE);
                editor.putBoolean("isVisible",true).apply();
                editor.putBoolean("isPlaying",true).apply();
                //int drawableID=getResources().getIdentifier("sugar","drawable",getPackageName());

            }
            else {
                editor.putBoolean("isVisible", false).apply();
                editor.putBoolean("isPlaying",false).apply();
            }

        }
        else {
            System.out.println("VISIBLE 3ady -----> 7ut link");
            String songName = sharedPreferences.getString(playlistName + songs_number, "not found");
            String currentSong=sharedPreferences.getString("currentSong","not found");
            if (songName.equals("  sugar")) {
                if(songName.equals(currentSong)==false)
                {
                    playbar.setText("  Sugar");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
                    img = getResources().getDrawable(R.drawable.sugar);
                }


            } else if (songName.equals("  maps")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  Maps");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
                    img = getResources().getDrawable(R.drawable.maps);
                }
            } else if (songName.equals("  Wanta maaya")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  Wanta maaya");
                    prepareMediaPlayer("http://music.egonair.com/2020/May/Tamer.Hosny.Cheb.Khaled.%20Wa.enta%20.Maayia.mp3");
                    img = getResources().getDrawable(R.drawable.wantamaaya);
                }
            } else if (songName.equals("  Helw elmakan")) {
                if(songName.equals(currentSong)==false) {
                    System.out.println("FALSE");
                    playbar.setText("  Helw elmakan");
                    prepareMediaPlayer("http://music.egonair.com/2019/Dec/Tamer.Hosny.Helw.El.Makan.mp3");
                    img = getResources().getDrawable(R.drawable.helwelmakan);
                }

            } else if (songName.equals("  LYA")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  LYA");
                    prepareMediaPlayer("http://music.egonair.com/2019/Feb/Aghanyna.CoM-Nancy.Ajram.Lya.mp3");
                    img = getResources().getDrawable(R.drawable.lya);
                }
            } else if (songName.equals("  EL OMR")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  EL OMR");
                    prepareMediaPlayer("http://music.egonair.com/2020/Apr/Nancy.Ajram.El.Omr.mp3");
                    img = getResources().getDrawable(R.drawable.elomr);
                }
            } else if (songName.equals("  Ya Sattar")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  Ya Sattar");
                    prepareMediaPlayer("https://www.aghanyna.com/arabic/wp-content/uploads/2019/01/Ya.Star_.mp3");
                    img = getResources().getDrawable(R.drawable.yasattar);
                }
            } else if (songName.equals("  We A3mal Eih")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  We A3mal Eih");
                    prepareMediaPlayer("https://www.aghanyna.com/arabic/wp-content/uploads/2019/01/Wa3ml.Eyh_.mp3");
                    img = getResources().getDrawable(R.drawable.wea3maleh);
                }
            } else if (songName.equals("  zaymanty")) {
                if(songName.equals(currentSong)==false) {
                    playbar.setText("  Zaymanty");
                    prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/10-Zay.Manty.mp3");
                    img = getResources().getDrawable(R.drawable.zaymanty);
                }
            } else if (songName.equals("  bahebu")) {
                if(songName.equals(currentSong)==false){
                playbar.setText("  Bahebu");
                prepareMediaPlayer("http://music.egonair.com/AmrDiab/2020/13-Bahebo.mp3");
                img = getResources().getDrawable(R.drawable.bahebu);}
            } else
                return;
            editor.putString("currentSong",songName).apply();
            img.setBounds(0, 0, 150, 150);



            if (isPlaying) {
                img2 = getResources().getDrawable(R.drawable.play_white);
                img2.setBounds(0, 0, 140, 140);
                System.out.println(img);
                playbar.setCompoundDrawables(img,null,img2,null);
                imageView.setImageResource(R.drawable.play_red);
                System.out.println("KUlo fl saleem");

                mediaPlayer.pause();
                System.out.println("BAZET KHALIS");
                editor.putBoolean("isPlaying",false).apply();
                isPlaying=false;
            }
            else
            {
                System.out.println(img);
                img2 = getResources().getDrawable(R.drawable.pause_white);
                img2.setBounds(0, 0, 140, 140);
                playbar.setCompoundDrawables(img,null,img2,null);
                imageView.setImageResource(R.drawable.pause_red);
                mediaPlayer.start();
                isPlaying=true;
                editor.putBoolean("isPlaying",true).apply();
            }
        }

    }
    /**
     * prepare mediaplayer with url of a song
     * @param url used to set mediaplayer
     */
    private void prepareMediaPlayer(String url)
    {
        try{
            current_url=url;
            System.out.println(url);
            System.out.println("EL DONIA eshta");
            if(mediaPlayer!=null) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                mediaPlayer.reset();
            }
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            isPlaying=false;
            editor.putString("song_url",url).apply();
            System.out.println("DONE");
            //songtimeTextView.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        }catch(Exception exception)
        {
            Toast.makeText(this,exception.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
