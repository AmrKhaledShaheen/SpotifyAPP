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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArtistProfile extends AppCompatActivity {
    private String [] adamSongs={"sugar","maps"};
    private String [] amrSongs={"zaymanty","bahebu"};
    private String [] tamerSongs={"Wanta maaya","Helw elmakan"};
    private String [] nancySongs={"EL OMR","LYA"};
    private String [] hamakiSongs={"Ya Sattar","We A3mal Eih"};
    private String [] waelSongs={"wael1","wael2"};
    private ImageView artistimage;
    private TextView artistname;
    private LinearLayout artistsongsLinearLayout;
    String artistName;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_profile);
        artistname=(TextView) findViewById(R.id.artistnametextView);
        artistimage=(ImageView) findViewById(R.id.artistimageView);
        artistsongsLinearLayout=(LinearLayout) findViewById(R.id.artistsongsLinearLayout);
        String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
        sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
        editor=sharedPreferences.edit();
        whichArtist();
    }
    public void whichArtist()
    {
        System.out.println("HIBYE");
        //artistName=getIntent().getStringExtra("artistName");
        artistName=sharedPreferences.getString("artistName","not found");
        if(artistName.equals("not found"))
            return;
        if(artistName.equals("  Adam Levine"))
        {
            Drawable img=getResources().getDrawable(R.drawable.adamfull);
            img.setBounds(0,0,1040,520);
            artistimage.setImageDrawable(img);
            artistname.setText(artistName);
            fillartistsongs(adamSongs,artistName);
        }
        else if(artistName.equals("  Amr Diab"))
        {
            Drawable img=getResources().getDrawable(R.drawable.amr);
            img.setBounds(0,0,1040,520);
            artistimage.setImageDrawable(img);
            artistname.setText(artistName);
            fillartistsongs(amrSongs,artistName);
        }
        else if(artistName.equals("  Tamer Hosny"))
        {
            Drawable img=getResources().getDrawable(R.drawable.tamer_hosny_liked);
            img.setBounds(0,0,1040,520);
            artistimage.setImageDrawable(img);
            artistname.setText(artistName);
            fillartistsongs(tamerSongs,artistName);
        }
        else if(artistName.equals("  Nancy Ajram"))
        {
            Drawable img=getResources().getDrawable(R.drawable.nancy_ajram_liked);
            img.setBounds(0,0,1040,520);
            artistimage.setImageDrawable(img);
            artistname.setText(artistName);
            fillartistsongs(nancySongs,artistName);
        }
        else if(artistName.equals("  Hamaki"))
        {
            Drawable img=getResources().getDrawable(R.drawable.mohamed_hamaki_liked);
            img.setBounds(0,0,1040,520);
            artistimage.setImageDrawable(img);
            artistname.setText(artistName);
            fillartistsongs(hamakiSongs,artistName);
        }
    }
    public void fillartistsongs(String [] songs,String Name)
    {
        LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0,30,0,0);
        if(artistName.equals("  Adam Levine")) {
            for (int i = 0; i < songs.length; i++) {
                Button button = new Button(this);

                Drawable img = null;
                if (songs[i].equals("sugar")) {
                    button.setText("  Sugar");
                    img = getResources().getDrawable(R.drawable.sugar);
                } else if (songs[i].equals("maps")) {
                    button.setText("  Maps");
                    img = getResources().getDrawable(R.drawable.maps);
                }

                if (img == null)
                    return;
                img.setBounds(0, 0, 200, 200);
                button.setTextSize(22);
                button.setPadding(40, 0, 0, 0);
                button.setAllCaps(false);

                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img, null, null, null);
                button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opensongDetails(v);
                    }
                });
                artistsongsLinearLayout.addView(button, k);
            }
        }
        else if(artistName.equals("  Amr Diab"))
        {
            for (int i = 0; i < songs.length; i++) {
                Button button = new Button(this);

                Drawable img = null;
                if (songs[i].equals("zaymanty")) {
                    button.setText("  Zaymanty");
                    img = getResources().getDrawable(R.drawable.zaymanty);
                } else if (songs[i].equals("bahebu")) {
                    button.setText("  Bahebu");
                    img = getResources().getDrawable(R.drawable.bahebu);
                }

                if (img == null)
                    return;
                img.setBounds(0, 0, 200, 200);
                button.setTextSize(22);
                button.setPadding(40, 0, 0, 0);
                button.setAllCaps(false);

                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img, null, null, null);
                button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opensongDetails(v);
                    }
                });
                artistsongsLinearLayout.addView(button, k);
            }
        }
        else if(artistName.equals("  Tamer Hosny"))
        {
            for (int i = 0; i < songs.length; i++) {
                Button button = new Button(this);

                Drawable img = null;
                if (songs[i].equals("Wanta maaya")) {
                    button.setText("  Wanta maaya");
                    img = getResources().getDrawable(R.drawable.wantamaaya);
                } else if (songs[i].equals("Helw elmakan")) {
                    button.setText("  Helw elmakan");
                    img = getResources().getDrawable(R.drawable.helwelmakan);
                }

                if (img == null)
                    return;
                img.setBounds(0, 0, 200, 200);
                button.setTextSize(22);
                button.setPadding(40, 0, 0, 0);
                button.setAllCaps(false);

                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img, null, null, null);
                button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opensongDetails(v);
                    }
                });
                artistsongsLinearLayout.addView(button, k);
            }
        }
        else if(artistName.equals("  Nancy Ajram"))
        {
            for (int i = 0; i < songs.length; i++) {
                Button button = new Button(this);

                Drawable img = null;
                if (songs[i].equals("LYA")) {
                    button.setText("  LYA");
                    img = getResources().getDrawable(R.drawable.lya);
                } else if (songs[i].equals("EL OMR")) {
                    button.setText("  EL OMR");
                    img = getResources().getDrawable(R.drawable.elomr);
                }

                if (img == null)
                    return;
                img.setBounds(0, 0, 200, 200);
                button.setTextSize(22);
                button.setPadding(40, 0, 0, 0);
                button.setAllCaps(false);

                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img, null, null, null);
                button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opensongDetails(v);
                    }
                });
                artistsongsLinearLayout.addView(button, k);
            }
        }
        else if(artistName.equals("  Hamaki"))
        {
            for (int i = 0; i < songs.length; i++) {
                Button button = new Button(this);

                Drawable img = null;
                if (songs[i].equals("Ya Sattar")) {
                    button.setText("  Ya Sattar");
                    img = getResources().getDrawable(R.drawable.yasattar);
                } else if (songs[i].equals("We A3mal Eih")) {
                    button.setText("  We A3mal Eih");
                    img = getResources().getDrawable(R.drawable.wea3maleh);
                }

                if (img == null)
                    return;
                img.setBounds(0, 0, 200, 200);
                button.setTextSize(22);
                button.setPadding(40, 0, 0, 0);
                button.setAllCaps(false);

                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img, null, null, null);
                button.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opensongDetails(v);
                    }
                });
                artistsongsLinearLayout.addView(button, k);
            }
        }
    }
    public void opensongDetails(View view)
    {
        Button btn=(Button) view;
        String songName=btn.getText().toString();
        Intent intent=new Intent(this,SongDetails.class);
        editor.putString("songName",songName);
        editor.apply();
        intent.putExtra("songName",songName);
        startActivity(intent);

    }
}
