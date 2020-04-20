package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Artist extends AppCompatActivity {
    /*private TextView artist1;
    private TextView artist2;
    private TextView artist3;
    private TextView artist4;
    private TextView artist5;
    private TextView artist6;*/
    private ImageView artist1true;
    private ImageView artist2true;
    private ImageView artist3true;
    private ImageView artist4true;
    private ImageView artist5true;
    private ImageView artist6true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent(R.layout.activity_artist);
    }


    public void setContent(int id)
    {
        setContentView(id);
        artist1true=(ImageView) findViewById(R.id.artist1true);
        artist2true=(ImageView) findViewById(R.id.artist2true);
        artist3true=(ImageView) findViewById(R.id.artist3true);
        artist4true=(ImageView) findViewById(R.id.artist4true);
        artist5true=(ImageView) findViewById(R.id.artist5true);
        artist6true=(ImageView) findViewById(R.id.artist6true);



    }
    public void goSearch(View view)
    {
        setContent(R.layout.activity_search);
    }
    public void backToArtist(View view)
    {
        setContent(R.layout.activity_artist);
    }

    public void chooseMe(View view)
    {
        ImageView imageView=(ImageView) findViewById(view.getId());
        String string=imageView.getTag().toString();
        switch (string)
        {
            case "artist1":
                System.out.println("artist1");
                if(artist1true.getVisibility()==View.VISIBLE)
                    artist1true.setVisibility(View.INVISIBLE);
                else
                    artist1true.setVisibility(View.VISIBLE);
                break;
            case "artist2":
                System.out.println("artist2");
                if(artist2true.getVisibility()==View.VISIBLE)
                    artist2true.setVisibility(View.INVISIBLE);
                else
                    artist2true.setVisibility(View.VISIBLE);
                break;
            case "artist3":
                System.out.println("artist3");
                if(artist3true.getVisibility()==View.VISIBLE)
                    artist3true.setVisibility(View.INVISIBLE);
                else
                    artist3true.setVisibility(View.VISIBLE);
                break;
            case "artist4":
                System.out.println("artist4");
                if(artist4true.getVisibility()==View.VISIBLE)
                    artist4true.setVisibility(View.INVISIBLE);
                else
                    artist4true.setVisibility(View.VISIBLE);
                break;
            case "artist5":
                System.out.println("artist5");
                if(artist5true.getVisibility()==View.VISIBLE)
                    artist5true.setVisibility(View.INVISIBLE);
                else
                    artist5true.setVisibility(View.VISIBLE);
                break;
            case "artist6":
                System.out.println("artist6");
                if(artist6true.getVisibility()==View.VISIBLE)
                    artist6true.setVisibility(View.INVISIBLE);
                else
                    artist6true.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void saveArtists(View view)
    {
        setContent(R.layout.activity_artist1);
    }





}