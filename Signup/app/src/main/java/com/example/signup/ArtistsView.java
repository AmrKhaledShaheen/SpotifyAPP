package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ArtistsView extends AppCompatActivity {
    private Button playlistsButton,artistsButton,albums,homeButton,searchButton,libraryButton,premiumButton,chooseartists_0artistsButton;
    private TextView textView1,textView2;
    LinearLayout allartistsLinearLayout;
    private int k=1;
    private int numberofartists;
    Drawable spotify1,spotify2,library1,library2,home1,home2,search1,search2;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences=getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        setContentView(R.layout.activity_artists_view);

        ///////////0 artist mode
        chooseartists_0artistsButton=(Button) findViewById(R.id.chooseartists_0artistsButton);
        textView1=(TextView) findViewById(R.id.textView1);
        textView2=(TextView) findViewById(R.id.textView2);

        ////////// more than 0 artist mode
        allartistsLinearLayout=(LinearLayout) findViewById(R.id.allartistsLinearLayout);





        playlistsButton=(Button) findViewById(R.id.playlistButton);
        artistsButton=(Button) findViewById(R.id.artistsButton);
        albums=(Button) findViewById(R.id.albumsButton);
        homeButton=(Button) findViewById(R.id.homeButton);
        searchButton=(Button) findViewById(R.id.searchButton);
        libraryButton=(Button) findViewById(R.id.libraryButton);
        premiumButton=(Button) findViewById(R.id.premiumButton);
        spotify1=getResources().getDrawable(R.drawable.ic_spotify);
        spotify2=getResources().getDrawable(R.drawable.ic_spotify2);
        library1=getResources().getDrawable(R.drawable.ic_library);
        library2=getResources().getDrawable(R.drawable.ic_library2);
        search1=getResources().getDrawable(R.drawable.ic_search);
        search2=getResources().getDrawable(R.drawable.ic_search2);
        home1=getResources().getDrawable(R.drawable.ic_homee);
        home2=getResources().getDrawable(R.drawable.ic_homee2);
        //setImgBounds();
        home1.setBounds(0,0,130,130);
        home2.setBounds(0,0,130,130);
        spotify1.setBounds(0,0,130,130);
        spotify2.setBounds(0,0,130,130);
        library1.setBounds(0,0,130,130);
        library2.setBounds(0,0,130,130);
        search2.setBounds(0,0,130,130);
        search1.setBounds(0,0,130,130);
        libraryButton.setTextColor(Color.WHITE);
        libraryButton.setCompoundDrawables(null,library2,null,null);
        loadData();
        //checknumberofartists();
    }
    public void loadData()
    {
        numberofartists=sharedPreferences.getInt("numberofartists",0);

        System.out.println(numberofartists);
        LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0,30,0,0);
        Drawable img=getResources().getDrawable(R.drawable.kafoury);
        if(numberofartists==0)
        {

            allartistsLinearLayout.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            chooseartists_0artistsButton.setVisibility(View.VISIBLE);
        }
        else
        {
            Button btn=new Button(this);
            btn.setTextSize(22);
            btn.setPadding(40,0,0,0);
            btn.setAllCaps(false);
            btn.setText("  Choose artists");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chooseArtist();
                }
            });
            img=getResources().getDrawable(R.drawable.roundedplus);
            btn.setBackgroundColor(Color.BLACK);
            img.setBounds(0,0,160,160);
            btn.setCompoundDrawables(img,null,null,null);
            btn.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
            allartistsLinearLayout.addView(btn,k);
            allartistsLinearLayout.setVisibility(View.VISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            chooseartists_0artistsButton.setVisibility(View.INVISIBLE);

            for(int i=1;i<=numberofartists;i++)
            {
                String name=sharedPreferences.getString("artist"+i,"sayed");
                System.out.println(name);
                Button button=new Button(this);

                if(name.equals("Adam Levine"))
                {
                    img=getResources().getDrawable(R.drawable.adam);
                }
                else if(name.equals("Wael Kfoury"))
                {
                    img=getResources().getDrawable(R.drawable.kafoury);
                }
                else if(name.equals("Amr Diab"))
                {
                    img=getResources().getDrawable(R.drawable.amr);
                }
                else if(name.equals("Tamer Hosny"))
                {
                    img=getResources().getDrawable(R.drawable.tamer);
                }
                else if(name.equals("Nancy Ajram"))
                {
                    img=getResources().getDrawable(R.drawable.nancy_croped2);
                }
                else if(name.equals("Hamaki"))
                {
                    img=getResources().getDrawable(R.drawable.hamaky_croped2);
                }
                img.setBounds(0,0,160,160);
                button.setTextSize(22);
                button.setPadding(40,0,0,0);
                button.setAllCaps(false);
                button.setText("  "+name);
                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img,null,null,null);
                button.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
                System.out.println("DONE"+i);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showProfile(v);
                    }
                });
                allartistsLinearLayout.addView(button,k);
                //Button btn=getIntent().getParcelableExtra("artists"+i+"Button");
                //allartistsLinearLayout.addView(btn);
            }
        }

    }
    public void openChooseArtist(View view)
    {
        chooseArtist();
    }
    public void chooseArtist()
    {
        Intent intent=new Intent(this, ChooseArtist.class);
        startActivity(intent);
    }

    public void playlistsCall(View view)
    {
        Intent intent=new Intent(this, Library.class);
        startActivity(intent);
    }
    public void albumsCall(View view)
    {
        Intent intent=new Intent(this, AlbumsView.class);
        startActivity(intent);
    }
    public void goHome(View view)
    {
        return;
    }

    public void goPremium(View view)
    {
        return;
    }

    public void goSearch(View view)
    {
        return;
    }
    public void goLibrary(View view)
    {
        Intent intent=new Intent(this, Library.class);
        startActivity(intent);
    }
    /*public void resetAll()
    {
        homeButton.setTextColor(getResources().getColor(R.color.greyHome));
        libraryButton.setTextColor(getResources().getColor(R.color.greyHome));
        searchButton.setTextColor(getResources().getColor(R.color.greyHome));
        premiumButton.setTextColor(getResources().getColor(R.color.greyHome));
        homeButton.setCompoundDrawables(null,home1,null,null);
        premiumButton.setCompoundDrawables(null,spotify1,null,null);
        searchButton.setCompoundDrawables(null,search1,null,null);
        libraryButton.setCompoundDrawables(null,library1,null,null);
    }*/
    public void checknumberofartists()
    {
        LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0,30,0,0);
        Drawable img=getResources().getDrawable(R.drawable.kafoury);
        numberofartists=getIntent().getIntExtra("artistsnumber",0);
        if(numberofartists==0)
        {

            allartistsLinearLayout.setVisibility(View.INVISIBLE);
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            chooseartists_0artistsButton.setVisibility(View.VISIBLE);
        }
        else
        {
            Button btn=new Button(this);
            btn.setTextSize(22);
            btn.setPadding(40,0,0,0);
            btn.setAllCaps(false);
            btn.setText("  Choose artists");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chooseArtist();
                }
            });
            img=getResources().getDrawable(R.drawable.roundedplus);
            btn.setBackgroundColor(Color.BLACK);
            img.setBounds(0,0,160,160);
            btn.setCompoundDrawables(img,null,null,null);
            btn.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
            allartistsLinearLayout.addView(btn,k);
            allartistsLinearLayout.setVisibility(View.VISIBLE);
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            chooseartists_0artistsButton.setVisibility(View.INVISIBLE);

            for(int i=1;i<=numberofartists;i++)
            {
                String name=getIntent().getStringExtra("button"+i+"text");
                System.out.println(name);
                Button button=new Button(this);
                if(name.equals("  Adam Levine"))
                {
                    img=getResources().getDrawable(R.drawable.adam);
                }
                else if(name.equals("  Wael Kfoury"))
                {
                    img=getResources().getDrawable(R.drawable.kafoury);
                }
                else if(name.equals("  Amr Diab"))
                {
                    img=getResources().getDrawable(R.drawable.amr);
                }
                else if(name.equals("  Tamer Hosny"))
                {
                    img=getResources().getDrawable(R.drawable.tamer);
                }
                img.setBounds(0,0,160,160);
                button.setTextSize(22);
                button.setPadding(40,0,0,0);
                button.setAllCaps(false);
                button.setText(getIntent().getStringExtra("button"+i+"text"));
                button.setBackgroundColor(Color.BLACK);
                button.setCompoundDrawables(img,null,null,null);
                button.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
                System.out.println("DONE"+i);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showProfile(v);
                    }
                });
                allartistsLinearLayout.addView(button,k);
                //Button btn=getIntent().getParcelableExtra("artists"+i+"Button");
                //allartistsLinearLayout.addView(btn);
            }
        }

    }
    public void showProfile(View view)
    {

        Intent intent=new Intent(this,ArtistProfile.class);

        Button btn=(Button) view;
        String artistname=btn.getText().toString();
        editor.putString("artistName",artistname);
        editor.apply();
        //intent.putExtra("artistName",artistname);
        System.out.println(artistname);
        startActivity(intent);

    }
}
