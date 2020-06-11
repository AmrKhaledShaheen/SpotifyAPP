package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

/**
 * This an activity shows all songs to choose between them
 * @version 1.0
 */

public class AllSongs extends AppCompatActivity {
    private LinearLayout linearLayout;
    private TextView textView;
    private String playlistName;
    private String [] songsName={"sugar","maps","zaymanty","bahebu","Wanta maaya","Helw elmakan","EL OMR","LYA","Ya Sattar","We A3mal Eih"};
    private boolean song1,song2,song3,song4,song5,song6,song7,song8,song9,song10;
    private boolean [] songstateArr={song1,song2,song3,song4,song5,song6,song7,song8,song9,song10};
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
    private Button[] buttonArr={button1,button2,button3,button4,button5,button6,button7,button8,button9,button10};
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public AllSongs() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
        sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
        editor=sharedPreferences.edit();

        setContentView(R.layout.activity_all_songs);
        textView=(TextView)findViewById(R.id.textView_songs);
        linearLayout=(LinearLayout) findViewById(R.id.allsongsLinearLayout);
        loadSongs();
        loadData();


    }
    /**
     * loads data in sharedpreferences to show songs of playlist
     */
    public void loadData()
    {
        playlistName=sharedPreferences.getString("playlistName","not found");
        for(int i=0;i<songstateArr.length;i++)
        {
            int count=i+1;
            songstateArr[i]=sharedPreferences.getBoolean(playlistName+"state"+count,false);
            if(songstateArr[i])
            {
                Drawable img_true=getResources().getDrawable(R.drawable.truesign);
                img_true.setBounds(0,0,80,80);
                Drawable img=buttonArr[i].getCompoundDrawables()[0];
                buttonArr[i].setCompoundDrawables(img,null,img_true,null);
            }
        }


    }
    public void loadSongs()
    {
        LinearLayout.LayoutParams k=
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0,30,0,0);
        Drawable img=getResources().getDrawable(R.drawable.kafoury);
        Drawable image_true=getResources().getDrawable(R.drawable.truesign);
        image_true.setBounds(0,0,80,80);
        for(int i=0;i<songsName.length;i++)
        {

            String name=songsName[i];
            buttonArr[i]=new Button(this);
            switch (name)
            {
                case "sugar":
                    img=getResources().getDrawable(R.drawable.sugar);
                    break;
                case "maps":
                    img=getResources().getDrawable(R.drawable.maps);
                    break;
                case "zaymanty":
                    img=getResources().getDrawable(R.drawable.zaymanty);
                    break;
                case "bahebu":
                    img=getResources().getDrawable(R.drawable.bahebu);
                    break;
                case "Wanta maaya":
                    img=getResources().getDrawable(R.drawable.wantamaaya);
                    break;
                case "Helw elmakan":
                    img=getResources().getDrawable(R.drawable.helwelmakan);
                    break;
                case "El OMR":
                    img=getResources().getDrawable(R.drawable.elomr);
                    break;
                case "LYA":
                    img=getResources().getDrawable(R.drawable.lya);
                    break;
                case "Ya Sattar":
                    img=getResources().getDrawable(R.drawable.yasattar);
                    break;
                case "We A3mal Eih":
                    img=getResources().getDrawable(R.drawable.wea3maleh);
                    break;
            }
            img.setBounds(0,0,160,160);
            buttonArr[i].setTextSize(22);
            buttonArr[i].setPadding(40,0,40,0);
            buttonArr[i].setAllCaps(false);
            buttonArr[i].setText("  "+name);
            buttonArr[i].setBackgroundColor(Color.BLACK);
            buttonArr[i].setCompoundDrawables(img,null,null,null);
            buttonArr[i].setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
            buttonArr[i].setTag(i);
            buttonArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chooseMe(v);
                }
            });
            linearLayout.addView(buttonArr[i],k);
        }

    }
    /**
     * used to like and dislike song and shows an icon which specifies that
     * @param v
     */
    public void chooseMe(View v)
    {
        Button b=(Button) v;
        Drawable img_true=b.getCompoundDrawables()[2];
        System.out.println(img_true);

        Drawable img=b.getCompoundDrawables()[0];
        int index=parseInt(b.getTag().toString());
        int count=index+1;
        if(img_true==null) {
            System.out.println("Null");
            img_true = getResources().getDrawable(R.drawable.truesign);
            img_true.setBounds(0,0,80,80);
            songstateArr[index]=true;
            editor.putBoolean(playlistName+"state"+count,true);
        }
        else {
            System.out.println("Not Null");
            img_true = null;
            songstateArr[index]=false;
            editor.putBoolean(playlistName+"state"+count,false);
        }

        System.out.println(img_true);
        b.setCompoundDrawables(img,null,img_true,null);
        linearLayout.removeViewAt(index);
        linearLayout.addView(b,index);
    }
    /**
     * Save liked songs for playlist
     * @param view
     */
    public void saveAddedSongs(View view) {
        int count=0;
        for (int i = 0; i < songstateArr.length; i++)
        {
            System.out.println(songstateArr[i]);
            if(songstateArr[i])
            {
                System.out.println("GASDADASDASDASDA");
                count++;
                String name=buttonArr[i].getText().toString();
                System.out.println(name);
                editor.putString(playlistName+count,name);

                editor.apply();

            }
        }
        editor.putInt(playlistName+"count",count);
        editor.apply();
        System.out.println("TMAM");
        Intent intent=new Intent(this, PlaylistDetails.class);
        startActivity(intent);
    }

}
